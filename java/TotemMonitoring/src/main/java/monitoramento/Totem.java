package monitoramento;

import java.time.LocalDateTime;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Massaru
 */
public class Totem {
    private final String sistemaOperacional;
    private Double cpu;
    private Double memoria;
    private Double disco;
    private LocalDateTime tempo;
    
    private SystemInfo si;
    private HardwareAbstractionLayer hw;
    private OperatingSystem os;

    public Totem() {
        si = new SystemInfo();
        
        hw = si.getHardware();
        os = si.getOperatingSystem();
        
        sistemaOperacional = hw.getComputerSystem().toString();
    }
    
    public void capturarDados(){
        this.capturaCpu();
        this.capturaMemoria();
        this.capturaDisco();
    }
        
    private void capturaMemoria(){
        
    }
    
    private void capturaCpu(){
        
    }
    
    private void capturaDisco(){
        
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public Double getCpu() {
        return cpu;
    }

    public Double getDisco() {
        return disco;
    }

    public Double getMemoria() {
        return memoria;
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public HardwareAbstractionLayer getHw() {
        return hw;
    }

    public OperatingSystem getOs() {
        return os;
    }

    public SystemInfo getSi() {
        return si;
    }
    
    
    
}
