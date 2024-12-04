import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import dto.OrderRequest;
import java.lang.ModuleLayer.Controller;
import org.junit.jupiter.api.Test;
import repository.PosRepository;
import service.PosService;

public class ApplicationTest {

    @Test
    public void 기능_테스트(){
        PosController posController = new PosController(new PosService(new PosRepository()));
        posController.orderRequest(new OrderRequest(1,1,1));
        posController.orderRequest(new OrderRequest(1,21,1));
        String orderResult = posController.getOrderResult(1);
        assertThat(orderResult.contains("후라이드 1 16000\n"
                + "콜라 1 1000")).isEqualTo(true);
    }

}
