package org.mozilla.javascript.commonjs.module;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

public class Bootstrap {

    private String script;

    public Bootstrap(String script) {
        String scriptPath = script;
        Path p = Paths.get(scriptPath);
        try {
            byte[] bytes = Files.readAllBytes(p);
            this.script = new String(bytes);
        } catch (IOException e) {
            System.err.println("Unable to load bootstrap script.");
        }
    }

    public Script getScript(Context cx) {
        return cx.compileString(this.script, "<bootstrap>", 1, null);
    }

}
