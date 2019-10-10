package monitoramento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author Massaru
 */
public class Totem {
    
    public static final DateTimeFormatter DATA_FORMATADA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");    
    
    private final String sistemaOperacional;
    private String cpu;
    private String memoria;
    private String disco;
    private String tempo;
    
    private SystemInfo si;
    private HardwareAbstractionLayer hw;
    private OperatingSystem os;
    
    public Totem() {
        si = new SystemInfo();
        
        hw = si.getHardware();
        os = si.getOperatingSystem();
        
        sistemaOperacional = hw.getComputerSystem().toString();
    }
    
    public void capturarDados() {
        this.capturaTempoAtual();
        this.cpu = this.capturaCpu(hw.getProcessor());
        this.memoria = this.capturaMemoria(hw.getMemory());
        this.disco = this.capturaDisco();
    }
    
    private void capturaTempoAtual() {
        this.setTempo(LocalDateTime.now().format(Totem.DATA_FORMATADA));
    }
    
    private String capturaMemoria(GlobalMemory mem) {
        return FormatUtil.formatBytes(mem.getAvailable());
        
    }
    
    private String capturaCpu(CentralProcessor pro) {
        return String.format("%.2f GHz", pro.getSystemCpuLoad());
    }
    
    private String capturaDisco() {
        long disponivel = 0;
        FileSystem fileSystem = os.getFileSystem();
        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore oSFileStore : fsArray) {
            disponivel += oSFileStore.getUsableSpace();
        }
        return FormatUtil.formatBytes(disponivel);
    }
    
    public String getSistemaOperacional() {
        return sistemaOperacional;
    }
    
    public String getCpu() {
        return cpu;
    }
    
    public String getDisco() {
        return disco;
    }
    
    public String getMemoria() {
        return memoria;
    }
    
    public String getTempo() {
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
    
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }    
}
