package EmojiMod.patches.com.megacrit.cardcrawl;

import EmojiMod.util.EmojiMappingUtils;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class ReplaceDynamicVariableExprEditor extends ExprEditor {
    @Override
    public void edit(MethodCall m) throws CannotCompileException {
        if (m.getClassName().equals(Integer.class.getName()) && m.getMethodName().equals("toString")) {
            m.replace(
        "{" +
                    "$_ = " + EmojiMappingUtils.class.getName() + ".replaceIntWithEmoji($1);" +
                "}"
            );
        }

    }

}
