package EmojiMod.patches.BaseMod;

import EmojiMod.patches.com.megacrit.cardcrawl.RenderDescriptionExprEditor;
import EmojiMod.patches.com.megacrit.cardcrawl.ReplaceDynamicVariableExprEditor;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import javassist.expr.ExprEditor;

public class RenderCustomDynamicVariablePatches {

    @SpirePatch(
            clz = basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.RenderCustomDynamicVariable.Inner.class,
            method = "subRenderDynamicVariable"
    )
    public static class ReplaceNumberWithEmojiAbstractCardPatch {
        public static ExprEditor Instrument() {
            return new ReplaceDynamicVariableExprEditor();
        }
    }

    @SpirePatch(
            clz = basemod.patches.com.megacrit.cardcrawl.screens.SingleCardViewPopup.RenderCustomDynamicVariable.Inner.class,
            method = "subRenderDynamicVariable"
    )
    public static class ReplaceNumberWithEmojiSingleCardViewPopupPatch {
        public static ExprEditor Instrument() {
            return new ReplaceDynamicVariableExprEditor();
        }
    }

    @SpirePatch(
            clz = basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.RenderCustomDynamicVariable.Inner.class,
            method = "subRenderDynamicVariable"
    )
    public static class LineSpacingDynamicVarAbstractCardPatch {
        public static ExprEditor Instrument() {
            String renderRotatedTextReplacement =
                "{ " +
                    "$7 = i * 2.50F * -font.getCapHeight() + draw_y - __instance.current_y + -3.0F;" +
                    "$_ = $proceed($$);" +
                " }";
            return new RenderDescriptionExprEditor(renderRotatedTextReplacement, false, true);
        }
    }

    @SpirePatch(
            clz = basemod.patches.com.megacrit.cardcrawl.screens.SingleCardViewPopup.RenderCustomDynamicVariable.Inner.class,
            method = "subRenderDynamicVariable"
    )
    public static class LineSpacingDynamicVarSingleCardViewPopupPatch {
        public static ExprEditor Instrument() {
            String renderRotatedTextReplacement =
                "{ " +
                    "$7 = i * 2.50F * -font.getCapHeight() + draw_y - current_y + -9.0F;" +
                    "$_ = $proceed($$);" +
                " }";
            return new RenderDescriptionExprEditor(renderRotatedTextReplacement, false, true);
        }
    }
}
