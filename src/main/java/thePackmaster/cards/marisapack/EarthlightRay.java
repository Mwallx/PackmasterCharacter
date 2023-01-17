package thePackmaster.cards.marisapack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.powers.marisapack.EarthlightRayPower;
import thePackmaster.util.Wiz;

import java.util.Locale;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class EarthlightRay extends AbstractMarisaCard {
    public final static String ID = makeID(EarthlightRay.class.getSimpleName());
    private static final int UPG_COST = 2, MAGIC = 3;

    public EarthlightRay() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.applyToSelf(new EarthlightRayPower(magicNumber));
    }

    public void upp() {
        upgradeBaseCost(UPG_COST);
    }
}
