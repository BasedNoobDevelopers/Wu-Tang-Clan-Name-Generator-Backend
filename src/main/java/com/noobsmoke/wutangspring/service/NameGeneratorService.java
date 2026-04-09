package com.noobsmoke.wutangspring.service;

import com.noobsmoke.wutangspring.dto.NameInputRequest;
import com.noobsmoke.wutangspring.dto.RandomNameResponseDTO;
import com.noobsmoke.wutangspring.exception.InputNotCorrectException;
import com.noobsmoke.wutangspring.model.Gender;
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
        Gender gender = nameInputRequest.gender();
        if ((gender != Gender.F && gender != Gender.M)) {
            throw new InputNotCorrectException("gender", gender.name(), "Gender Input Incorrect");
        }
        int nameSize = nameRepo.getNameSize();
        int titleSize = nameRepo.getTitleNameSize();
        int imageSize = nameRepo.getImageListSize(nameInputRequest.gender());

        int randomFirstIndex = getRandomIndex(nameSize);
        int randomSecondIndex;
        int randomThirdIndex = getRandomIndex(titleSize);
        int randomFourthIndex = getRandomIndex(imageSize);


        do {
            randomSecondIndex = getRandomIndex(nameSize);
        } while (randomFirstIndex == randomSecondIndex);

        String firstName = nameRepo.getNameByIndex(randomFirstIndex);
        String secondName = nameRepo.getNameByIndex(randomSecondIndex);
        String titleName = nameRepo.getTitleByIndex(randomThirdIndex);
        String imageUrl = nameRepo.getImageByGender(randomFourthIndex, nameInputRequest.gender());
        String fullName = String.join(" ", firstName, secondName, titleName);

        return new RandomNameResponseDTO(
                firstName,
                secondName,
                titleName,
                fullName,
                imageUrl
        );
    }

    private int getRandomIndex(int bound) {
        return random.nextInt(bound);
    }
}
