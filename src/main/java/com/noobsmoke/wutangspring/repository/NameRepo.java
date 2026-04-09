package com.noobsmoke.wutangspring.repository;

import com.noobsmoke.wutangspring.model.Gender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class NameRepo {

    private final static List<String> names = new ArrayList<>();
    private final static List<String> titleNames = new ArrayList<>();
    private final static List<String> maleImages = new ArrayList<>();
    private final static List<String> femaleImages = new ArrayList<>();
    private final static Map<Gender, List<String>> imagesMap = new HashMap<>();
    @Value("${image-service.prefix}")
    private String imageServicePrefix;

    static {
        Collections.addAll(names,
                "Crimson", "Shadow", "Iron", "Storm", "Silent", "Ruthless",
                "Draco", "Phantom", "Steel", "Nova", "Masta", "Dragon",
                "Tiger", "Ronin", "Mantis", "Cipher", "Killah", "Lotus",
                "Katana", "Live", "Monarch", "God"
        );

        Collections.addAll(titleNames,
                "The Chamber Guardian",
                "The Beat Assassin",
                "The Rhythm Monk",
                "The Flow General",
                "The Iron Lyricist",
                "Hidden Warrior",
                "Of The Street Philosophers",
                "Champion of the Shadows",
                "Strategist Supreme",
                "The Silent Conqueror",
                "The Elder God"
        );

        Collections.addAll(maleImages,
                "WuTang_Male_1.jpg",
                "WuTang_Male_2.jpg",
                "WuTang_Male_3.jpg",
                "WuTang_Male_4.jpg",
                "WuTang_Male_5.jpg",
                "WuTang_Male_6.jpg",
                "WuTang_Male_7.jpg",
                "WuTang_Male_8.jpg",
                "WuTang_Male_9.jpg"
        );

        Collections.addAll(femaleImages,
                "WuTang_Female_1.jpg",
                "WuTang_Female_2.jpg",
                "WuTang_Female_3.jpg",
                "WuTang_Female_4.jpg",
                "WuTang_Female_5.jpg",
                "WuTang_Female_6.jpg",
                "WuTang_Female_7.jpg"
        );

        imagesMap.put(Gender.M, maleImages);
        imagesMap.put(Gender.F, femaleImages);
    }

    private boolean isOutOfBounds(int index, List<String> list) {
        return index < 0 || index >= list.size();
    }

    public String getNameByIndex(int index) {
        if (isOutOfBounds(index, names)) {
            throw new IllegalArgumentException("Out of bounds");
        }
        return names.get(index);
    }

    public String getTitleByIndex(int index) {
        if (isOutOfBounds(index, titleNames)) {
            throw new IllegalArgumentException("Out of bounds");
        }
        return titleNames.get(index);
    }

    public String getImageByGender(int index, Gender gender) {
        List<String> imageList = imagesMap.get(gender);
        if (isOutOfBounds(index, imageList)) {
            throw new IllegalArgumentException("Out of bounds");
        }

        return imageServicePrefix + imageList.get(index);
    }

    public int getNameSize() {
        return names.size();
    }

    public int getTitleNameSize() {
        return titleNames.size();
    }

    public int getImageListSize(Gender gender) {
        return imagesMap.get(gender).size();
    }
}
