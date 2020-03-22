package ru.itis.hateoasrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.hateoasrest.models.WishList;
import ru.itis.hateoasrest.services.WishListService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class WishListsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishListService wishListService;

    @BeforeEach
    public void setUp() {
        when(wishListService.publish(1L)).thenReturn(publishedWishList());
    }

    @Test
    public void wishListPublishTest() throws Exception {
        mockMvc.perform(put("/wishLists/1/publish")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value(publishedWishList().getTitle()))
        .andExpect(jsonPath("$.state").value(publishedWishList().getState()));
    }

    private WishList publishedWishList() {
        return new WishList(1L, "test", "Published");
    }

}
