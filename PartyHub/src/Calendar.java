import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class Calendar {
    // Mapa para armazenar a disponibilidade das datas
    private Map<LocalDate, Boolean> availability;

    // Construtor
    public Calendar() {
        availability = new HashMap<>();
        initializeAvailability();
    }

    // Inicializar todas as datas como disponíveis
    private void initializeAvailability() {
        LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 31);
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            availability.put(date, true); // true indica disponibilidade
            date = date.plusDays(1);
        }
    }

    // Marcar uma data como indisponível
    public void markUnavailable(LocalDate date) {
        if (availability.containsKey(date)) {
            availability.put(date, false);
        }
    }

    // Verificar a disponibilidade de uma data
    public boolean isAvailable(LocalDate date) {
        return availability.getOrDefault(date, false);
    }

}