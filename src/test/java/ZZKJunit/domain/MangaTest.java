package ZZKJunit.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    public void setUp() {
        manga1 = new Manga("Boruto", 200);
        manga2 = new Manga("Boruto", 200);
    }

    @Test
    public void acessors_ReturnData_WhenInitialized() {
        Assertions.assertEquals("Boruto", manga1.name());
        Assertions.assertEquals(200, manga1.episodes());
    }

    @Test
    public void equals_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1, manga2);
    }

    @Test
    public void hashCode_ReturnTrue_WhenObjectsAreTheSame() {
        Assertions.assertEquals(manga1.hashCode(), manga2.hashCode());
    }

    @Test
    public void constructor_ThrowNullPointerException_WhenNameisNull() {
        Assertions.assertThrows(NullPointerException.class,()->new Manga(null,100));
    }
    @Test
    public void isRecord_ReturnTrue_WhenCalledFromManga() {
        Assertions.assertTrue(Manga.class.isRecord());
    }
}