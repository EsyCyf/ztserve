package com.ares.ztserve.model;

/**
 * @author ESy
 * @date 2023/2/23 023 17:10
 */
public class ClientHolder {
    private static ThreadLocal<Client> tl =new ThreadLocal<Client>();

    // 存数据
    public static void saveClient(Client client){
        tl.set(client);
    }

    //取数据
    public static Client getClient(){
        return tl.get();
    }

    //删除数据
    public static void removeClient(){
        tl.remove();
    }
}
