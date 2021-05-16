package com.rhitm.scorecard.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.rhitm.scorecard.domain.Hole;
import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.dto.create.HoleRequest;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;

import org.springframework.beans.BeanUtils;

public final class ScorecardBeanUtils {

    //Not intended for this class to be instantiated
    private ScorecardBeanUtils() {}

    /**
     * Performs a deep copy of a <code>ScorecardTemplateRequest</code> to a <code>ScorecardTemplate</code>.
     * 
     * @param source a populated ScorecardTemplateRequest
     * @param target an initialized ScorecardTemplate
     */
    public static void copyProperties(@Valid ScorecardTemplateRequest source, ScorecardTemplate target) {
        //Shallow copy
        BeanUtils.copyProperties(source, target);

        //Handle list of Holes
        target.setHoles(new ArrayList<>(source.getHoles().size()));

        for(HoleRequest sourceHole : source.getHoles()) {
            Hole targetHole = new Hole();
            target.getHoles().add(targetHole);
            BeanUtils.copyProperties(sourceHole, targetHole);
        }
    }
}
