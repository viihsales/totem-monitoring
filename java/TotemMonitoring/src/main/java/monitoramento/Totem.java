package monitoramento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.FormatUtil;
import oshi.util.Util;

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
    private String processos;

    private final SystemInfo si;
    private final HardwareAbstractionLayer hw;
    private final OperatingSystem os;

    public Totem() {
        si = new SystemInfo();

        hw = si.getHardware();
        os = si.getOperatingSystem();

        sistemaOperacional = hw.getComputerSystem().toString();
    }

    private String capturarProcessos(final OperatingSystem os, final GlobalMemory memory) {

        StringBuilder builder = new StringBuilder();

//        builder.append(String.format("\n%-17s %-20s %-20s %-20s %-20s %-30s",
//                "", "PID", "%CPU", "%MEM", "VSZ", "RSS Name"));
        final List<OSProcess> procs;
        procs = Arrays.asList(os.getProcesses(30, ProcessSort.CPU));

        for (int i = 0; i < procs.size(); i++) {
            final OSProcess p = procs.get(i);

            String pid = String.valueOf(p.getProcessID());
            String cpuPorcentagem = String.valueOf(100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime()).substring(0, 7);
            Double memPorcentagem = 100d * p.getResidentSetSize() / memory.getTotal();
            String virtualSize = FormatUtil.formatBytes(p.getVirtualSize());
            String residentSize = FormatUtil.formatBytes(p.getResidentSetSize());
            String name = p.getName();
//            String[] teste = {pid, cpuPorcentagem, memPorcentagem, virtualSize, residentSize, name};;
//            
//            for (int count = 0; count < teste.length; count++) {
//                if(teste[i].length() < 20)
//            }

            builder.append(String.format("\n%20s %20s %20.1f %-20s %-20s %10s",
                    pid,
                    cpuPorcentagem,
                    memPorcentagem,
                    virtualSize,
                    residentSize,
                    name));
        }
        return builder.toString();
    }

    public void capturarDados() {
        this.capturaTempoAtual();

        this.cpu = this.capturaCpu(hw.getProcessor());
        this.memoria = this.capturaMemoria(hw.getMemory());
        this.disco = this.capturaDisco();

        this.processos = capturarProcessos(os, hw.getMemory());
    }

    private void capturaTempoAtual() {
        this.setTempo(LocalDateTime.now().format(Totem.DATA_FORMATADA));
    }

    private String capturaMemoria(GlobalMemory mem) {
        return FormatUtil.formatBytes(mem.getAvailable());
    }

    private String capturaCpu(CentralProcessor pro) {
        long[] ticks = pro.getSystemCpuLoadTicks();
        Util.sleep(1000);
        return String.format("%.2f%%", pro.getSystemCpuLoadBetweenTicks(ticks) * 100);
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

    public String getProcessos() {
        return processos;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

}
