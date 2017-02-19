package epochclock.evolution.branchratemodel;

import beast.core.Description;
import beast.core.Input;
import beast.core.Input.Validate;
import beast.core.parameter.RealParameter;
import beast.evolution.branchratemodel.*;
import beast.evolution.tree.Node;


@Description("Epoch clock model with varying rates per time interval")
public class RelaxedEpochClockModel extends UCRelaxedClockModel {
	public Input<RealParameter> epochTimeTopsInput = new Input<>("epochTimeTops","specifies top of time intervals", Validate.REQUIRED);
	public Input<RealParameter> relativeRateInput = new Input<>("relativeRates", "specifies clock rate relative to mean rate for each epoch", Validate.REQUIRED);

	
	RealParameter meanRate;
	RealParameter epochTimeTops;
	RealParameter relativeRates;
	
	@Override
	public void initAndValidate() {
		meanRate = meanRateInput.get();
		epochTimeTops = epochTimeTopsInput.get();
		relativeRates = relativeRateInput.get();
		
		if (epochTimeTops.getDimension() != relativeRates.getDimension() -1) {
			throw new IllegalArgumentException("dimension of epochTopTimes should be one less than that of relatviceRates");
		}
		
	}

	@Override
	public double getRateForBranch(Node node) {
		double rate = super.getRateForBranch(node);
		if (node.isRoot()) {
			return rate;
		}
		
		double height = node.getHeight();
		double parentHeight = node.getParent().getHeight();
		
		
		double relativeRate = 0;
		double intervalHeightBottom = 0;
		for (int i = 0; i < relativeRates.getDimension(); i++) {
			double intervalHeightTop = 
					(i < epochTimeTops.getDimension() ? epochTimeTops.getArrayValue(i) : Double.POSITIVE_INFINITY);

			if (intervalHeightTop >= height) {
				if (intervalHeightBottom < height && intervalHeightTop > height) {
					if (intervalHeightTop > parentHeight) {
						// all included in 1 epoch
						relativeRate = relativeRates.getArrayValue(i);
					} else {
						relativeRate = relativeRates.getArrayValue(i) * (intervalHeightTop-height)/(parentHeight-height);
					}
				} else if (intervalHeightBottom >= height && intervalHeightTop < parentHeight) {
					relativeRate += relativeRates.getArrayValue(i) * (intervalHeightTop-intervalHeightBottom)/(parentHeight-height);
				} else if (intervalHeightBottom >= height && parentHeight > intervalHeightBottom) {
					relativeRate += relativeRates.getArrayValue(i) * (parentHeight-intervalHeightBottom)/(parentHeight-height);
				} 
		 	}
			
			intervalHeightBottom = intervalHeightTop;
		}
		
		
		
		return rate * relativeRate;
	}
	
}
