package test.alexander.day5.service.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.alexander.day5.exception.ProgramException;
import com.alexander.day5.service.impl.ChangeTextStringServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangeTextStringServiceTest {
    ChangeTextStringServiceImpl service;
    String text;

    @BeforeClass
    public void setUp() {
        service = new ChangeTextStringServiceImpl();
        text = "Then, they heard a loud noise coming from a cupboard in the corner of the room.";
    }

    @Test
    public void replaceIndexLetterInWordPositiveTest() {
        try {
            String actualResult = service.replaceIndexLetterInWord(3, '1', text);
            String expectedResult = "The1 the1 hea1d a lou1 noi1e com1ng fro1 a cup1oard in the cor1er of the roo1";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test
    public void replaceIndexLetterInWordNegativeTest() {
        try {
            String actualResult = service.replaceIndexLetterInWord(10, '1', text);
            String expectedResult = "Then they heard a loud noise coming from a cupboard in the corner of the room";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void replaceIndexLetterInWordExceptionTest() throws ProgramException {
        service.replaceIndexLetterInWord(-2, '1', text);
    }

    @Test
    public void fixMistakePositiveTest() {
        try {
            String actualResult = service.fixMistake(text, 'c', 'o', 'A');
            String expectedResult = "Then, they heard a loud noise cAming from a cupboard in the cArner of the room.";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test
    public void fixMistakeNegativeTest() {
        try {
            String actualResult = service.fixMistake(text, 'v', 'o', 'A');
            String expectedResult = "Then, they heard a loud noise coming from a cupboard in the corner of the room.";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void fixMistakeExceptionTest() throws ProgramException {
        service.fixMistake(null, 'c', 'o', 'A');
    }

    @Test
    public void replaceWordsCertainLengthPositiveTest() {
        try {
            String actualResult = service.replaceWordsCertainLength(text, 4, "HELLO");
            String expectedResult = "HELLO HELLO heard a HELLO noise coming HELLO a cupboard in the corner of the HELLO";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test
    public void replaceWordsCertainLengthNegativeTest() {
        try {
            String actualResult = service.replaceWordsCertainLength(text, 10, "HELLO");
            String expectedResult = "Then they heard a loud noise coming from a cupboard in the corner of the room";
            assertEquals(actualResult, expectedResult, "fail test");
        } catch (ProgramException e) {
            fail("fail test");
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void replaceWordsCertainLengthExceptionTest() throws ProgramException {
        service.replaceWordsCertainLength(null, 4, "HELLO");
    }
}
