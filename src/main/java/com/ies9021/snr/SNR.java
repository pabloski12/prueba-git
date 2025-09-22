
package com.ies9021.snr;

import com.ies9021.snr.config.DbConnection;

public class SNR {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DbConnection conn = new DbConnection();
        conn.conectar();
    }
}
