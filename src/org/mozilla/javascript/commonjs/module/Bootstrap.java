package org.mozilla.javascript.commonjs.module;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

public class Bootstrap {

    private String script;

    public Bootstrap(String script) {
        this.script = script;
    }

    public Script getScript(Context cx) {
        return cx.compileString(this.script, "<bootstrap>", 1, null);
    }

}
