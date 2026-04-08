package com.noobsmoke.wutangspring.service;

import com.noobsmoke.wutangspring.dto.NameInputRequest;
import com.noobsmoke.wutangspring.dto.RandomNameResponseDTO;
import com.noobsmoke.wutangspring.repository.NameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class NameGeneratorService {

    private final NameRepo nameRepo;
    private final Random random;


    public RandomNameResponseDTO generateNewName(NameInputRequest nameInputRequest) {
        int nameSize = nameRepo.getNameSize();
        int titleSize = nameRepo.getTitleNameSize();

        int randomFirstIndex = getRandomIndex(nameSize);
        int randomSecondIndex;
        int randomThirdIndex = getRandomIndex(titleSize);


        do {
            randomSecondIndex = getRandomIndex(nameSize);
        } while (randomFirstIndex == randomSecondIndex);

        String firstName = nameRepo.getNameByIndex(randomFirstIndex);
        String secondName = nameRepo.getNameByIndex(randomSecondIndex);
        String titleName = nameRepo.getTitleByIndex(randomThirdIndex);
        String fullName = String.join(" ", firstName, secondName, titleName);

        return new RandomNameResponseDTO(
                firstName,
                secondName,
                titleName,
                fullName,
                null
        );
    }

    private int getRandomIndex(int bound) {
        return random.nextInt(bound);
    }
}
