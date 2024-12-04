import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.OrderManager;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void 주문은_99_넘어갈_수_없음(){
        OrderManager orderManager = new OrderManager();
        Menu menu = MenuRepository.menus().get(0);
        assertThatThrownBy(() -> {
            orderManager.addOrder(new Order(100,menu),1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 주문은_1개이상(){
        OrderManager orderManager = new OrderManager();
        Menu menu = MenuRepository.menus().get(0);
        assertThatThrownBy(() -> {
            orderManager.addOrder(new Order(0,menu),1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 테이블은_존재해야함(){
        OrderManager orderManager = new OrderManager();
        Menu menu = MenuRepository.menus().get(0);
        assertThatThrownBy(() -> {
            orderManager.addOrder(new Order(100,menu),-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
