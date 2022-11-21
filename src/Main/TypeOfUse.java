package Main;

import java.io.File;
import java.net.Socket;

public abstract class TypeOfUse {
    protected File file;
    protected String path;

    protected long timeOfStart;
    protected long timeOfEnd;

    public abstract boolean connect();
}
