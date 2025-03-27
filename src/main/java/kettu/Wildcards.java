package kettu;

import java.util.Arrays;
import java.util.List;

interface OperatingSystem {
  public void boot();
}

interface Unix extends OperatingSystem {
}

interface BSD extends Unix {
}

class FreeBSD implements BSD {
  @Override
  public void boot() {
    System.out.println("FreeBSD is booting...");
  }
}

class OpenBSD implements BSD {
  @Override
  public void boot() {
    System.out.println("OpenBSD is booting...");
  }
}

interface Linux extends Unix {
}

class Debian implements Linux {
  @Override
  public void boot() {
    System.out.println("Debian is booting...");
  }
}

class ArchLinux implements Linux {
  @Override
  public void boot() {
    System.out.println("ArchLinux is booting...");
  }
}

interface macOS extends Unix {
}

class iOS implements macOS {
  @Override
  public void boot() {
    System.out.println("iOS is booting...");
  }
}

class watchOS implements macOS {
  @Override
  public void boot() {
    System.out.println("watchOS is booting...");
  }
}

interface Windows extends OperatingSystem {
}

interface WindowsNT extends Windows {
}

class Windows11 implements WindowsNT {
  @Override
  public void boot() {
    System.out.println("Windows11 is booting...");
  }
}

class WindowsServer implements WindowsNT {
  @Override
  public void boot() {
    System.out.println("WindowsServer is booting...");
  }
}

public class Wildcards {

  public static void upperBoundedExample() {
    List<OperatingSystem> osList = Arrays.asList(
        new FreeBSD(),
        new OpenBSD(),
        new Debian(),
        new ArchLinux(),
        new iOS(),
        new watchOS(),
        new Windows11(),
        new WindowsServer());

    bootAll(osList);
  }

  private static void bootAll(List<? extends OperatingSystem> osList) {
    osList.forEach(OperatingSystem::boot);
  }
}
