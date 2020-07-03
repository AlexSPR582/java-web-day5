package test.alexander.day5.service.impl;

import static org.testng.Assert.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.impl.DeleteTextCharSequenceServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteTextCharSequenceServiceTest {
    DeleteTextCharSequenceServiceImpl service;
    String text;

    @BeforeClass
    public void setUp() {
        service = new DeleteTextCharSequenceServiceImpl();
        text = "Then, they heard a loud%?* noise coming 43from a cupboard -in the' corner of the room.";
    }

    @Test
    public void deleteNotLetterPositiveTest() {
        try {
            String actualResult = service.deleteNotLetter(text);
            String expectedResult = "Then  they heard a loud    noise coming   from a cupboard  in the  corner of the room ";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test
    public void deleteNotLetterNegativeTest() {
        try {
            String actualResult = service.deleteNotLetter(text);
            String expectedResult = "Then, they heard a loud%?* noise coming 43from a cupboard -in the' corner of the room.";
            assertNotEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void deleteNotLetterExceptionTest() throws ProgramException {
        service.deleteNotLetter(null);
    }

    @Test
    public void deleteWordsBeginWithConstantCertainLengthPositiveTest() {
        try {
            String actualResult = service.deleteWordsBeginWithConstantCertainLength(text, 4);
            String expectedResult = "heard a noise coming a cupboard in the corner of the";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test
    public void deleteWordsBeginWithConstantCertainLengthNegativeTest() {
        try {
            String actualResult = service.deleteWordsBeginWithConstantCertainLength(text, 10);
            String expectedResult = "Then they heard a loud noise coming from a cupboard in the corner of the room";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void deleteWordsBeginWithConstantCertainLengthExceptionTest() throws ProgramException {
        service.deleteWordsBeginWithConstantCertainLength(null, -4);
    }
}
