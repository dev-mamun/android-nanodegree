package net.alisra.inventoryappstage2.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import net.alisra.inventoryappstage2.data.InventoryContract.InventoryEntry;

public class InventoryProvider extends ContentProvider {

    private static final int PROUDCTS = 100;
    private static final int PROUDCT_ID = 101;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(InventoryContract.CONTENT_AUTHORITY, InventoryContract.PATH_INVENTORY, PROUDCTS);
        sUriMatcher.addURI(InventoryContract.CONTENT_AUTHORITY, InventoryContract.PATH_INVENTORY + "/#", PROUDCT_ID);
    }

    private InventoryDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new InventoryDbHelper((getContext()));
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case PROUDCTS:
                cursor = database.query(InventoryEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case PROUDCT_ID:
                selection = InventoryEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(InventoryEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PROUDCTS:
                return insertProduct(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }

    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PROUDCTS:
                return InventoryEntry.CONTENT_LIST_TYPE;
            case PROUDCT_ID:
                return InventoryEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI" + uri + " with match " + match);
        }
    }

    private Uri insertProduct(Uri uri, ContentValues values) {
        String nameProduct = values.getAsString(InventoryEntry.COLUMN_PRODUCT_NAME);
        if (nameProduct == null) {
            throw new IllegalArgumentException("Product name requires");
        }

        Integer priceProduct = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_PRICE);
        if (priceProduct != null && priceProduct < 0) {
            throw new IllegalArgumentException("Product price requires valid");
        }

        Integer quantityProduct = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_QUANTITY);
        if (quantityProduct != null && quantityProduct < 0) {
            throw new IllegalArgumentException("Product quantity requires valid");
        }

        Integer supplierName = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME);
        if (supplierName == null || !InventoryEntry.isValidSupplierName(supplierName)) {
            throw new IllegalArgumentException("Pet requires valid gender");
        }

        Integer supplierPhone = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER);
        if (supplierPhone != null && supplierPhone < 0) {
            throw new IllegalArgumentException("Supplier Phone requires valid");
        }

        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        long id = database.insert(InventoryEntry.TABLE_NAME, null, values);
        if (id == -1) {
            Log.v("message:", "Failed to insert new row for " + uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        int rowsDeleted;

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PROUDCTS:
                rowsDeleted = database.delete(InventoryEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case PROUDCT_ID:
                selection = InventoryEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                rowsDeleted = database.delete(InventoryEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }
        if (rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection, String[]
            selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PROUDCTS:
                return updateProduct(uri, contentValues, selection, selectionArgs);
            case PROUDCT_ID:
                selection = InventoryEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updateProduct(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }

    private int updateProduct(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (values.containsKey(InventoryEntry.COLUMN_PRODUCT_NAME)) {
            String nameProduct = values.getAsString(InventoryEntry.COLUMN_PRODUCT_NAME);
            if (nameProduct == null) {
                throw new IllegalArgumentException("Product name requires");
            }
        }
        if (values.containsKey(InventoryEntry.COLUMN_PRODUCT_PRICE)) {
            Integer priceProduct = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_PRICE);
            if (priceProduct != null && priceProduct < 0) {
                throw new
                        IllegalArgumentException("Product price requires valid");
            }
        }

        if (values.containsKey(InventoryEntry.COLUMN_PRODUCT_QUANTITY)) {
            Integer quantityProduct = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_QUANTITY);
            if (quantityProduct != null && quantityProduct < 0) {
                throw new
                        IllegalArgumentException("Product quantity requires valid");
            }
        }
        if (values.containsKey(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME)) {
            Integer supplierName = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_NAME);
            if (supplierName == null || !InventoryEntry.isValidSupplierName(supplierName)) {
                throw new IllegalArgumentException("Supplier Name requires valid");
            }
        }

        if (values.containsKey(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER)) {
            Integer supplierPhone = values.getAsInteger(InventoryEntry.COLUMN_PRODUCT_SUPPLIER_PHONE_NUMBER);
            if (supplierPhone != null && supplierPhone < 0) {
                throw new
                        IllegalArgumentException("Supplier Phone requires valid");
            }
        }

        if (values.size() == 0) {
            return 0;
        }

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        int rowsUpdated = database.update(InventoryEntry.TABLE_NAME, values, selection, selectionArgs);

        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsUpdated;
    }
}
