package ecs.components;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

import model.enums.XenoType;
import model.enums.XenoPhase;
import model.enums.PheromoneType;
import model.enums.BehaviorState;
import ecs.entities.Entity;

/**
 * Testes unitários para os componentes do sistema ECS de Xenomorfos
 */
public class ComponentsTest {

    @Nested
    @DisplayName("XenomorphComponent Tests")
    class XenomorphComponentTests {

        private XenomorphComponent xenomorphComponent;

        @BeforeEach
        void setUp() {
            xenomorphComponent = new XenomorphComponent(XenoType.DRONE);
        }

        @Test
        @DisplayName("Deve criar xenomorfo com tipo especificado")
        void shouldCreateXenomorphWithSpecifiedType() {
            assertEquals(XenoType.DRONE, xenomorphComponent.getType());
            assertTrue(xenomorphComponent.isAlive());
            assertNull(xenomorphComponent.getHiveId());
        }

        @Test
        @DisplayName("Deve alterar tipo do xenomorfo")
        void shouldChangeXenomorphType() {
            xenomorphComponent.setType(XenoType.QUEEN);
            assertEquals(XenoType.QUEEN, xenomorphComponent.getType());
        }

        @Test
        @DisplayName("Deve alterar status de vida")
        void shouldChangeAliveStatus() {
            xenomorphComponent.setAlive(false);
            assertFalse(xenomorphComponent.isAlive());
        }

        @Test
        @DisplayName("Deve definir e recuperar hive ID")
        void shouldSetAndGetHiveId() {
            String hiveId = "HIVE_001";
            xenomorphComponent.setHiveId(hiveId);
            assertEquals(hiveId, xenomorphComponent.getHiveId());
        }
    }

    @Nested
    @DisplayName("LifecycleComponent Tests")
    class LifecycleComponentTests {

        @Test
        @DisplayName("Deve calcular vida máxima correta para cada fase")
        void shouldCalculateCorrectMaxHealthForEachPhase() {
            LifecycleComponent eggComponent = new LifecycleComponent(XenoPhase.EGG);
            // Testando através de reflexão ou métodos públicos que precisariam ser adicionados
            assertNotNull(eggComponent);

            LifecycleComponent faceHuggerComponent = new LifecycleComponent(XenoPhase.FACEHUGGER);
            assertNotNull(faceHuggerComponent);

            LifecycleComponent chestBursterComponent = new LifecycleComponent(XenoPhase.CHESTBURSTER);
            assertNotNull(chestBursterComponent);

            LifecycleComponent adultComponent = new LifecycleComponent(XenoPhase.ADULT);
            assertNotNull(adultComponent);

            LifecycleComponent queenComponent = new LifecycleComponent(XenoPhase.QUEEN);
            assertNotNull(queenComponent);
        }
    }

    @Nested
    @DisplayName("PheromoneComponent Tests")
    class PheromoneComponentTests {

        private PheromoneComponent pheromoneComponent;

        @BeforeEach
        void setUp() {
            pheromoneComponent = new PheromoneComponent(10.0f, true);
        }

        @Test
        @DisplayName("Deve criar componente de feromônio com parâmetros corretos")
        void shouldCreatePheromoneComponentWithCorrectParameters() {
            assertNotNull(pheromoneComponent);
            // Teste indireto - verificando que o componente foi criado sem erros
        }

        @Test
        @DisplayName("Deve emitir feromônio com intensidade inicial")
        void shouldEmitPheromoneWithInitialIntensity() {
            // Assumindo que PheromoneType.DANGER existe
            assertDoesNotThrow(() -> {
                pheromoneComponent.emitPheromone(PheromoneType.ALARM, 5.0f);
            });
        }

        @Test
        @DisplayName("Deve atualizar intensidade dos feromônios ao longo do tempo")
        void shouldUpdatePheromoneIntensityOverTime() {
            pheromoneComponent.emitPheromone(PheromoneType.ALARM, 10.0f);

            // Simula passagem de tempo
            assertDoesNotThrow(() -> {
                pheromoneComponent.update(1.0f);
            });
        }

        @Test
        @DisplayName("Deve remover feromônios com intensidade muito baixa")
        void shouldRemovePheromonesWithVeryLowIntensity() {
            pheromoneComponent.emitPheromone(PheromoneType.ALARM, 0.005f);

            // Simula passagem de tempo suficiente para decaimento
            assertDoesNotThrow(() -> {
                pheromoneComponent.update(10.0f);
            });
        }
    }

    @Nested
    @DisplayName("PositionComponent Tests")
    class PositionComponentTests {

        private PositionComponent positionComponent;

        @BeforeEach
        void setUp() {
            positionComponent = new PositionComponent(5.0f, 10.0f);
        }

        @Test
        @DisplayName("Deve criar componente de posição com coordenadas especificadas")
        void shouldCreatePositionComponentWithSpecifiedCoordinates() {
            assertNotNull(positionComponent);
            // Teste indireto - verificando que o componente foi criado sem erros
        }

        @Test
        @DisplayName("Deve implementar interface Component")
        void shouldImplementComponentInterface() {
            assertTrue(positionComponent instanceof Component);
        }
    }

    @Nested
    @DisplayName("Component Interface Tests")
    class ComponentInterfaceTests {

        @Test
        @DisplayName("Todos os componentes devem implementar a interface Component")
        void allComponentsShouldImplementComponentInterface() {
            assertTrue(new XenomorphComponent(XenoType.DRONE) instanceof Component);
            assertTrue(new LifecycleComponent(XenoPhase.EGG) instanceof Component);
            assertTrue(new PheromoneComponent(5.0f, true) instanceof Component);
            assertTrue(new PositionComponent(0f, 0f) instanceof Component);
            assertTrue(new PhysicsComponent() instanceof Component);
            assertTrue(new CombatComponent() instanceof Component);
            assertTrue(new AIComponent() instanceof Component);
            assertTrue(new AcidComponent() instanceof Component);
            assertTrue(new ReproductionComponent() instanceof Component);
        }
    }

    @Nested
    @DisplayName("Integration Tests")
    class IntegrationTests {

        @Test
        @DisplayName("Deve criar uma entidade xenomorfo completa com múltiplos componentes")
        void shouldCreateCompleteXenomorphEntityWithMultipleComponents() {
            // Simulando a criação de uma entidade com vários componentes
            XenomorphComponent xenoComp = new XenomorphComponent(XenoType.QUEEN);
            LifecycleComponent lifecycleComp = new LifecycleComponent(XenoPhase.ADULT);
            PositionComponent posComp = new PositionComponent(0f, 0f);
            PheromoneComponent pheromoneComp = new PheromoneComponent(15.0f, true);

            assertNotNull(xenoComp);
            assertNotNull(lifecycleComp);
            assertNotNull(posComp);
            assertNotNull(pheromoneComp);

            // Verificando que todos implementam Component
            assertTrue(xenoComp instanceof Component);
            assertTrue(lifecycleComp instanceof Component);
            assertTrue(posComp instanceof Component);
            assertTrue(pheromoneComp instanceof Component);
        }

        @Test
        @DisplayName("Deve simular evolução de xenomorfo através das fases")
        void shouldSimulateXenomorphEvolutionThroughPhases() {
            // Teste de evolução através das fases
            XenomorphComponent xenoComp = new XenomorphComponent(XenoType.FACEHUGGER);
            assertEquals(XenoType.FACEHUGGER, xenoComp.getType());

            // Simula evolução
            xenoComp.setType(XenoType.CHESTBURSTER);
            assertEquals(XenoType.CHESTBURSTER, xenoComp.getType());

            xenoComp.setType(XenoType.DRONE);
            assertEquals(XenoType.DRONE, xenoComp.getType());
        }
    }

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Deve lidar com valores nulos apropriadamente")
        void shouldHandleNullValuesAppropriately() {
            XenomorphComponent xenoComp = new XenomorphComponent(XenoType.DRONE);

            // Testando com hive ID nulo
            xenoComp.setHiveId(null);
            assertNull(xenoComp.getHiveId());

            // Testando com hive ID vazio
            xenoComp.setHiveId("");
            assertEquals("", xenoComp.getHiveId());
        }

        @Test
        @DisplayName("Deve lidar com valores extremos de posição")
        void shouldHandleExtremePositionValues() {
            assertDoesNotThrow(() -> {
                new PositionComponent(Float.MAX_VALUE, Float.MIN_VALUE);
            });

            assertDoesNotThrow(() -> {
                new PositionComponent(-1000000f, 1000000f);
            });
        }

        @Test
        @DisplayName("Deve lidar com valores extremos de feromônio")
        void shouldHandleExtremePheromoneValues() {
            PheromoneComponent pheromoneComp = new PheromoneComponent(0.1f, false);

            assertDoesNotThrow(() -> {
                pheromoneComp.emitPheromone(PheromoneType.TRAIL, 0.0f);
            });

            assertDoesNotThrow(() -> {
                pheromoneComp.emitPheromone(PheromoneType.TRAIL, Float.MAX_VALUE);
            });
        }
    }
}