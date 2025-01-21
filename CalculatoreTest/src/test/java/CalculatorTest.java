import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	
	@InjectMocks
	Calculator calculator;
	
	@Mock
	CalculatorService calculatorService;
	
	@BeforeEach
    void setUp() {
        calculator = new Calculator(calculatorService);
    }

    @Test
    public void testAdd() {
        when(calculatorService.add(2, 3)).thenReturn(5);

        assertEquals(5, calculator.add(2, 3));

        verify(calculatorService).add(2, 3);
    }

    @Test
    public void testSubtract() {
        when(calculatorService.subtract(5, 3)).thenReturn(2);

        assertEquals(2, calculator.subtract(5, 3));

        verify(calculatorService).subtract(5, 3);
    }

    @Test
    public void testMultiply() {
        when(calculatorService.multiply(2, 3)).thenReturn(6);

        assertEquals(6, calculator.multiply(2, 3));

        verify(calculatorService).multiply(2, 3);
    }

    @Test
    public void testDivide() {
        when(calculatorService.divide(6, 3)).thenReturn(2);

        assertEquals(2, calculator.divide(6, 3));

        verify(calculatorService).divide(6, 3);
    }

    @Test
    public void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
}