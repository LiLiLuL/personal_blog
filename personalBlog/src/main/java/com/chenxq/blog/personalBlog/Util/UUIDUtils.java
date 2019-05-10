package com.chenxq.blog.personalBlog.Util;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
