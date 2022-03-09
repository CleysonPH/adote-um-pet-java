package br.com.treinaweb.adoteumpet.api.pet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long> {

    private final PetRepository petRepository;

    public PetExistsByIdValidator(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return petRepository.existsById(value);
    }

}
