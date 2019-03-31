import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import junitparams.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)

public class ValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void validateIdDocumentIsTrue1() {
        assertTrue(validator.validate("CEV737475"));
    }

    @Test
    public void validateIdDocumentIsTrue2() {
        assertTrue(validator.validate("AKW555665"));
    }

    @Test
    public void validateIdDocumentLengthTrue() {
        assertTrue(validator.validate("AKW555665"));
    }


    @Test
    public void validateIdDocumentLengthFalse() {
        assertFalse(validator.validate("AKW5556"));
    }

    @Test
    public void validateIdDocumentStructureTrue() {
        assertTrue(validator.validate("AKW555665"));
    }

    @Test
    @Parameters({"Akw555t65", "AKW555A65", "Akw555t65", "Ak1555665"})
    public void validateIdDocumentStructureFalse(String input) {
        Validator validator2 = new Validator();
        assertFalse(validator2.validate(input));
    }

    @Test
    public void validateIdDocumentControlNumberTrue() {
        assertTrue(validator.validate("AKW555665"));
    }

    @Test
    public void validateIdDocumentControlNumberFalse() {
        String idDok = "AKW155665";
        assertThat(validator.validate(idDok)).isFalse();
    }

    @Test
    public void validateIdDocumentIsEmptyFalse() {
        String idDok = "";
        assertThat(validator.validate(idDok)).isFalse();
    }

    @Test
    public void validateIdDocumentIsNulFalse() {
        assertThat(validator.validate(null)).isFalse();
    }

}