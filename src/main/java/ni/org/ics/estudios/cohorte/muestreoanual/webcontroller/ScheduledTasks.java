package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
 
public class ScheduledTasks
{
	@Scheduled(cron="0 0/30 * * * ?")
    public void demoServiceMethod()
    {
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }
}