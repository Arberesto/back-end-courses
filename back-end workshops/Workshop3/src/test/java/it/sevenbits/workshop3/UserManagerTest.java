package it.sevenbits.workshop3;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp() {
        ICollection mockCollection = mock(ICollection.class);
        when(mockCollection.get(1)).thenReturn(new User("Vasya","default"));
        this.userManager = new UserManager(mockCollection);
    }

    @Test
    public void testGetUserByIndex() throws UserManagerException {
        UserManager mockManager

    }
    @Test
    public void testCreateDefault() throws UserManagerException {
        int[] array = {1, 2, 3};
        assertEquals("Wrong!Should be 5", 5, this.pairSummater.sum(array));
    }

    @Test
    public void testPairSummaterEmptyArray() throws UserManagerException {
        int[] array = {};
        assertEquals("Wrong!Should be 0", 0, this.pairSummater.sum(array));
    }

}