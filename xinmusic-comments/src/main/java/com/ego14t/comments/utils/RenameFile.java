package com.ego14t.comments.utils;

import com.ego14t.common.utils.EgoCode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangfx
 * Created by EGo1sT
 * @Date Created in 2021/1/15 13:55
 * Description:
 */
public class RenameFile {
    public static void rename(String oldpath, String newpath) {
        Map<String, Long> map = new HashMap<>();
        map.put("1", 90390131827015680L);
        map.put("10", 90390133198553088L);
        map.put("11", 90390133555068928L);
        map.put("12", 90390133974499328L);
        map.put("13", 90390134242934784L);
        map.put("14", 90390134708502528L);
        map.put("15", 90390135085989888L);
        map.put("16", 90390135404756992L);
        map.put("17", 90390135887101952L);
        map.put("18", 90390136272977920L);
        map.put("19", 90390136952455168L);
        map.put("2", 90390137644515328L);
        map.put("20", 90390138101694464L);
        map.put("21", 90390138516930560L);
        map.put("22", 90390139007664128L);
        map.put("23", 90390139280293888L);
        map.put("24", 90390139666169856L);
        map.put("25", 90390140161097728L);
        map.put("26", 90390140651831296L);
        map.put("27", 90390141171924992L);
        map.put("28", 90390141910122496L);
        map.put("29", 90390142711234560L);
        map.put("3", 90390143130664960L);
        map.put("30", 90390143554289664L);
        map.put("4", 90390144489619456L);
        map.put("5", 90390144837746688L);
        map.put("6", 90390145223622656L);
        map.put("7", 90390145609498624L);
        map.put("8", 90390146003763200L);
        map.put("9", 90390146616131584L);

        File file = new File(oldpath);
        // get the folder list
        File[] array = file.listFiles();

        for(int i=0;i<array.length;i++){
            if(array[i].isFile()){
                System.out.println("oldFileName===" + array[i].getName());
                String oldfileName = array[i].getName().substring(0, array[i].getName().lastIndexOf("."));
                File oldFile = array[i];
                File newFile = new File(newpath + "\\" + EgoCode.encode(map.get(oldfileName)) + ".jpg");
                oldFile.renameTo(newFile);
            }
        }
    }

    public static void main(String[] args) {
        String oldpath = "C:\\Users\\Administrator\\Desktop\\xinmusic\\cover";
        String newpath = "C:\\Users\\Administrator\\Desktop\\xinmusic\\newcover";
        rename(oldpath, newpath);
    }
}
