package seedu.address.storage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonSerializableFinSecTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableFinSecTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");

    //    @Test
    //    public void toModelType_typicalPersonsFile_success() throws Exception {
    //        JsonSerializableFinSec dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
    //                JsonSerializableFinSec.class).get();
    //        FinSec finSecFromFile = dataFromFile.toModelType();
    //        FinSec typicalPersonsFinSec = TypicalContacts.getTypicalFinSec();
    //        assertEquals(finSecFromFile, typicalPersonsFinSec);
    //    }

    //    @Test
    //    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
    //        JsonSerializableFinSec dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
    //                JsonSerializableFinSec.class).get();
    //        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    //    }

    //    @Test
    //    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
    //        JsonSerializableFinSec dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
    //                JsonSerializableFinSec.class).get();
    //        assertThrows(IllegalValueException.class, JsonSerializableFinSec.MESSAGE_DUPLICATE_PERSON,
    //                dataFromFile::toModelType);
    //    }

}