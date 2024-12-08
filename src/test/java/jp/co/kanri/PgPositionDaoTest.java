package jp.co.kanri;

import jp.co.kanri.dao.impl.PgPositionDao;
import jp.co.kanri.entity.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest // Springコンテキストをロードしてテスト実行
@ActiveProfiles("test") // テスト用プロパティを適用
public class PgPositionDaoTest {

    @Autowired
    private PgPositionDao positionDao;

    @Test
    void findAll_ShouldReturnAllPositions() {
        // 実行
        List<Position> result = positionDao.findAll();

        // 検証
        assertThat(result).hasSize(2); // データが2件存在することを確認
        assertThat(result.get(0).getPositionName()).isEqualTo("株主");
        assertThat(result.get(1).getPositionName()).isEqualTo("課長");
    }
}
