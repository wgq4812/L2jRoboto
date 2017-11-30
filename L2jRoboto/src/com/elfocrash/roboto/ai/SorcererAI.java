package com.elfocrash.roboto.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.elfocrash.roboto.FakePlayer;
import com.elfocrash.roboto.FakePlayerManager;

import javafx.util.Pair;
import net.sf.l2j.gameserver.model.ShotType;

/**
 * @author Elfocrash
 *
 */
public class SorcererAI extends FakePlayerAI
{
	private List<Pair<Integer,Double>> _offensiveSpells;
	
	public SorcererAI(FakePlayer character)
	{
		super(character);		
	}
	
	@Override
	public void thinkAndAct()
	{
		if(_fakePlayer.isDead()) {
			return;
		}
		
		buffPlayer();
		handleShots();
		
		tryTargetRandomCreatureByTypeInRadius(FakePlayer.class, 1200);	
		
		tryAttackingUsingMageOffensiveSkill();
	}
	
	@Override
	protected ShotType getShotType()
	{
		return ShotType.BLESSED_SPIRITSHOT;
	}
	
	@Override
	protected List<Pair<Integer, Double>> getOffensiveSpells()
	{
		_offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new Pair<>(1230, 50d));
		_offensiveSpells.add(new Pair<>(1339, 50d));
		return _offensiveSpells; 
	}
	
	@Override
	protected int[][] getBuffs()
	{
		return FakePlayerManager.INSTANCE.getMageBuffs();
	}

	@Override
	protected List<Pair<Integer, Double>> getHealingSpells()
	{		
		return Collections.emptyList();
	}
}