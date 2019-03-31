import org.junit.Before;
import org.junit.Test;
import junitparams.Parameters;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void validateIdDokumentIsTrue1() {
        assertTrue(validator.validate("CEV737475"));
    }

    @Test
    public void validateIdDokumentIsTrue2() {
        assertTrue(validator.validate("AKW555665"));
    }

    @Test
    public void validateIdDokumentLengthTrue() {
        assertTrue(validator.validate("AKW555665"));
    }

    @Test
    public void validateIdDokumentLengthFalse() {
        assertFalse(validator.validate("AKW5556"));
    }

    @Test
    public void validateIdDokumentStructureTrue() {
        assertFalse(validator.validate("AKW555665"));
    }

    @Test
    @Parameters({"akw555665", "AKW555A65", "Akw555t65", "Ak1555665"})
    public void validateIdDokumentStructureFals(String input) {
        assertFalse(validator.validate(input));
    }

    @Test
    public void validateIdDokumentControlNumberTrue() {
        assertTrue(validator.validate("AKW555665"));
    }

    @Test
    public void validateIdDokumentControlNumberFalse() {
        String idDok = "AKW155665";
        assertThat(validator.validate(idDok)).isFalse();
    }



}