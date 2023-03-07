package thePackmaster.cards.spherespack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.orbs.spherespack.Polar;

public class Winterwisp extends AbstractSpheresCard {
    public static final String ID = SpireAnniversary5Mod.makeID("Winterwisp");
    private static final int COST = 1;
    private static final int DAMAGE = 8;
    private static final int UPGRADE_DAMAGE = 11;

    public Winterwisp() {
        super(ID, COST, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = DAMAGE;
    }

    @Override
    public void upp() {
        this.upgradeDamage(UPGRADE_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        this.addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                boolean hasEmptyOrb = p.hasEmptyOrb();
                AbstractOrb newOrb = new Polar();
                if (hasEmptyOrb) {
                    addToTop(new AbstractGameAction() {
                        @Override
                        public void update() {
                            newOrb.onStartOfTurn();
                            this.isDone = true;
                        }
                    });
                }
                addToTop(new ChannelAction(newOrb));
                this.isDone = true;
            }
        });
    }
}
