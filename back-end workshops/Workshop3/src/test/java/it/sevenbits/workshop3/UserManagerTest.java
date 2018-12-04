package it.sevenbits.workshop3;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserManagerTest {

    private UserManager userManager;

    @Test
    public void testGetUserByIndex1() throws UserManagerException,IOException {
        ICollection mockCollection = mock(ICollection.class);
        when(mockCollection.get(1)).thenReturn(new User("Vasya", "default"));
        when(mockCollection.get(3)).thenReturn(new User("Petya", "elite"));
        this.userManager = new UserManager(mockCollection);
        User user = userManager.getUserByIndex(1);
        assertEquals("default", user.getRole());
        assertEquals("Vasya", user.getName());
        user = userManager.getUserByIndex(3);
        assertEquals("elite", user.getRole());
        assertEquals("Petya", user.getName());
    }

    @Test(expected = UserManagerException.class)
    public void testGetUserByIndex2() throws UserManagerException,IOException {
        ICollection mockCollection = mock(ICollection.class);
        this.userManager = new UserManager(mockCollection);
        when(mockCollection.get(2)).thenThrow(new IOException("No element of that index"));
        userManager.getUserByIndex(2);
    }

    @Test
    public void testCreateDefault() throws UserManagerException,IOException {
        ICollection mockCollection = mock(ICollection.class);
        when(mockCollection.get(1)).thenReturn(new User("Ivan", "default"));
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocationOnMock)
                    throws Throwable {
                User user = (User) invocationOnMock.getArguments()[0];
                assertEquals("Ivan",user.getName());
                assertEquals("default",user.getRole());
                return null;
            }
        }).when(mockCollection).add(any(User.class));
        this.userManager = new UserManager(mockCollection);
        userManager.createDefault("Ivan");
    }

}