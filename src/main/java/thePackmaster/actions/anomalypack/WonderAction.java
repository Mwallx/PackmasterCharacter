package thePackmaster.actions.anomalypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import thePackmaster.util.Wiz;

public class WonderAction extends AbstractGameAction {
    public WonderAction() {
        this.duration = 0.001F;
    }

    public void update() {
        this.tickDuration();
        if (this.isDone) {
            for (AbstractCard c : DrawCardAction.drawnCards) {
                Wiz.atb(new LoseEnergyAction(EnergyPanel.totalCount));
                Wiz.atb(new GainEnergyAction(Wiz.getLogicalCardCost(c)));
            }
        }
    }
}
