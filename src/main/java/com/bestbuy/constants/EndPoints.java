package com.bestbuy.constants;
// **** Created By Harshit Patel ****

public class EndPoints {


    /**
     * Endpoints for PRODUCTS
     */
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/products/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/products/{productID}";
    public static final String DELETE_PRODUCT_BY_ID = "/products/{productID}";

    /**
     * Endpoints for STORES
     */
    public static final String GET_SINGLE_STORE_BY_ID = "/stores/{storeID}";
    public static final String GET_ALL_STORE = "/stores";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storeID}";
    public static final String DELETE_STORE_BY_ID = "/stores/{storeID}";
}
