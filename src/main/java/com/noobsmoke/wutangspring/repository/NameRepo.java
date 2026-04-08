package com.noobsmoke.wutangspring.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class NameRepo {

    private final static List<String> names = new ArrayList<>();
    private final static List<String> titleNames = new ArrayList<>();

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

    public int getNameSize() {
        return names.size();
    }

    public int getTitleNameSize() {
        return titleNames.size();
    }
}
