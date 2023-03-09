package staffingOptimization;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;

import com.anylogic.libraries.modules.markup_descriptors.*;
import com.anylogic.libraries.processmodeling.*;

import java.awt.geom.Arc2D;

/**
 * Case: A bank wants to optimize its staffing levels to minimize customer wait times while still controlling costs. The bank currently has 5 tellers working during peak hours, but they want to determine if this is the optimal number of tellers or if they should increase or decrease staff levels.<br>
 * <br>
 * To model this case in AnyLogic, you could create a discrete event simulation model that simulates customer arrivals and service times at the bank. The model would take into account factors such as the number of tellers available, the arrival rate of customers, and the time it takes for each teller to serve a customer.<br>
 * <br>
 * To start, you could define the arrival process of customers using a Poisson distribution. You could then define the service times of each teller using an exponential distribution. You would also need to define the capacity of the system, which in this case would be the number of tellers available to serve customers.<br>
 * <br>
 * Next, you could use the model to simulate different staffing levels by changing the number of tellers available during peak hours. For each staffing level, you could run the simulation multiple times to generate statistics such as the average wait time for customers and the percentage of customers who have to wait in line.<br>
 * <br>
 * Finally, you could use the results of the simulation to determine the optimal number of tellers to have during peak hours, balancing the need to minimize customer wait times with the desire to control costs.
 */
public class Scenario_AlterAtBusyHours extends Agent
{
  // Parameters

  public 
double  IAT;

  /**
   * Returns default value for parameter <code>IAT</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _IAT_DefaultValue_xjal() {
    final Scenario_AlterAtBusyHours self = this;
    return 
5 
;
  }

  public void set_IAT( double value ) {
    if (value == this.IAT) {
      return;
    }
    double _oldValue_xjal = this.IAT;
    this.IAT = value;
    onChange_IAT_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter IAT.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_IAT()</code> method instead.
   */
  protected void onChange_IAT() {
    onChange_IAT_xjal( IAT );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_IAT_xjal( double oldValue ) {  
  }


  public 
int  hrCostTeller;

  /**
   * Returns default value for parameter <code>hrCostTeller</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _hrCostTeller_DefaultValue_xjal() {
    final Scenario_AlterAtBusyHours self = this;
    return 
400 
;
  }

  public void set_hrCostTeller( int value ) {
    if (value == this.hrCostTeller) {
      return;
    }
    int _oldValue_xjal = this.hrCostTeller;
    this.hrCostTeller = value;
    onChange_hrCostTeller_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter hrCostTeller.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_hrCostTeller()</code> method instead.
   */
  protected void onChange_hrCostTeller() {
    onChange_hrCostTeller_xjal( hrCostTeller );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_hrCostTeller_xjal( int oldValue ) {  
  }


  public 
int  overhead;

  /**
   * Returns default value for parameter <code>overhead</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _overhead_DefaultValue_xjal() {
    final Scenario_AlterAtBusyHours self = this;
    return 
10000 
;
  }

  public void set_overhead( int value ) {
    if (value == this.overhead) {
      return;
    }
    int _oldValue_xjal = this.overhead;
    this.overhead = value;
    onChange_overhead_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter overhead.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_overhead()</code> method instead.
   */
  protected void onChange_overhead() {
    onChange_overhead_xjal( overhead );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_overhead_xjal( int oldValue ) {  
  }


  public 
int  tellerCapacityNotBusy;

  /**
   * Returns default value for parameter <code>tellerCapacityNotBusy</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _tellerCapacityNotBusy_DefaultValue_xjal() {
    final Scenario_AlterAtBusyHours self = this;
    return 
3 
;
  }

  public void set_tellerCapacityNotBusy( int value ) {
    if (value == this.tellerCapacityNotBusy) {
      return;
    }
    int _oldValue_xjal = this.tellerCapacityNotBusy;
    this.tellerCapacityNotBusy = value;
    onChange_tellerCapacityNotBusy_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter tellerCapacityNotBusy.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_tellerCapacityNotBusy()</code> method instead.
   */
  protected void onChange_tellerCapacityNotBusy() {
    onChange_tellerCapacityNotBusy_xjal( tellerCapacityNotBusy );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_tellerCapacityNotBusy_xjal( int oldValue ) {
	int index;
    {
      com.anylogic.libraries.processmodeling.ResourcePool<Agent> self = Tellers;
      int _value;
      _value = tellerCapacityNotBusy
;
      Tellers.set_capacity( _value );
    }  
  }


  public 
int  tellerCapacityBusy;

  /**
   * Returns default value for parameter <code>tellerCapacityBusy</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _tellerCapacityBusy_DefaultValue_xjal() {
    final Scenario_AlterAtBusyHours self = this;
    return 
6 
;
  }

  public void set_tellerCapacityBusy( int value ) {
    if (value == this.tellerCapacityBusy) {
      return;
    }
    int _oldValue_xjal = this.tellerCapacityBusy;
    this.tellerCapacityBusy = value;
    onChange_tellerCapacityBusy_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter tellerCapacityBusy.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_tellerCapacityBusy()</code> method instead.
   */
  protected void onChange_tellerCapacityBusy() {
    onChange_tellerCapacityBusy_xjal( tellerCapacityBusy );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_tellerCapacityBusy_xjal( int oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    IAT = _IAT_DefaultValue_xjal();
    hrCostTeller = _hrCostTeller_DefaultValue_xjal();
    overhead = _overhead_DefaultValue_xjal();
    tellerCapacityNotBusy = _tellerCapacityNotBusy_DefaultValue_xjal();
    tellerCapacityBusy = _tellerCapacityBusy_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "IAT":
      if ( _callOnChange_xjal ) {
        set_IAT( ((Number) _value_xjal).doubleValue() );
      } else {
        IAT = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "hrCostTeller":
      if ( _callOnChange_xjal ) {
        set_hrCostTeller( ((Number) _value_xjal).intValue() );
      } else {
        hrCostTeller = ((Number) _value_xjal).intValue();
      }
      return true;
    case "overhead":
      if ( _callOnChange_xjal ) {
        set_overhead( ((Number) _value_xjal).intValue() );
      } else {
        overhead = ((Number) _value_xjal).intValue();
      }
      return true;
    case "tellerCapacityNotBusy":
      if ( _callOnChange_xjal ) {
        set_tellerCapacityNotBusy( ((Number) _value_xjal).intValue() );
      } else {
        tellerCapacityNotBusy = ((Number) _value_xjal).intValue();
      }
      return true;
    case "tellerCapacityBusy":
      if ( _callOnChange_xjal ) {
        set_tellerCapacityBusy( ((Number) _value_xjal).intValue() );
      } else {
        tellerCapacityBusy = ((Number) _value_xjal).intValue();
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "IAT": _result_xjal = IAT; break;
    case "hrCostTeller": _result_xjal = hrCostTeller; break;
    case "overhead": _result_xjal = overhead; break;
    case "tellerCapacityNotBusy": _result_xjal = tellerCapacityNotBusy; break;
    case "tellerCapacityBusy": _result_xjal = tellerCapacityBusy; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "IAT" );
      list.add( "hrCostTeller" );
      list.add( "overhead" );
      list.add( "tellerCapacityNotBusy" );
      list.add( "tellerCapacityBusy" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 nQueue;
  public 
int 
 salary;
  public 
double 
 utilizationBeforeBusy;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Scenario_AlterAtBusyHours.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }


  // Events

  public EventTimeout triggerBusyHours = new EventTimeout(this);
  public EventTimeout incrementHrSalary = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _statisticsQueue_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == triggerBusyHours ) return "triggerBusyHours";
     if( _e == incrementHrSalary ) return "incrementHrSalary";
     if( _e == _statisticsQueue_autoUpdateEvent_xjal ) return "statisticsQueue auto update event";
     if( _e == _plot_autoUpdateEvent_xjal ) return "plot auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == triggerBusyHours ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == incrementHrSalary ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _statisticsQueue_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == triggerBusyHours ) {
      _t = 
4 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == incrementHrSalary ) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _statisticsQueue_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == triggerBusyHours) {
      _t = 
2 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == incrementHrSalary) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _statisticsQueue_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, MINUTE );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == triggerBusyHours ) {
      EventTimeout self = _e;


// check if simulation clock has exceeded 4 hours, if true increase the pace of
// arrivals and increase staffing to 5 tellers. At the 6th hour, return to staffing 
// of 3 tellers and old IAT.

if (time() == 4) {
	IAT = 2;
	utilizationBeforeBusy = Tellers.utilization();
	Tellers.set_capacity(tellerCapacityBusy);
} else {
	IAT = 5;
	Tellers.set_capacity(tellerCapacityNotBusy);
}


// Keep monitoring active
self.restart(); 
;
      return;
    }
    if ( _e == incrementHrSalary ) {
      EventTimeout self = _e;

// increment the salary cost for the tellers

salary += hrCostTeller * Tellers.capacity;

traceln(Tellers.capacity); 
;
      return;
    }
    if ( _e == _statisticsQueue_autoUpdateEvent_xjal ) {
      statisticsQueue.update();
      return;
    }
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      plot.updateData();
      return;
    }
    super.executeActionOf( _e );
  }

	

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  public com.anylogic.libraries.processmodeling.Source<
Agent 
> letInCustomers;
  public com.anylogic.libraries.processmodeling.Seize<
Agent 
> seizeCustomer;
  public com.anylogic.libraries.processmodeling.Delay<
Agent 
> handleCustomer;
  public com.anylogic.libraries.processmodeling.Release<
Agent 
> releaseCustomer;
  public com.anylogic.libraries.processmodeling.ResourcePool<
Agent 
> Tellers;
  public com.anylogic.libraries.processmodeling.Sink<
Agent 
> customerLeave;

  public String getNameOf( Agent ao ) {
    if ( ao == letInCustomers ) return "letInCustomers";
    if ( ao == seizeCustomer ) return "seizeCustomer";
    if ( ao == handleCustomer ) return "handleCustomer";
    if ( ao == releaseCustomer ) return "releaseCustomer";
    if ( ao == Tellers ) return "Tellers";
    if ( ao == customerLeave ) return "customerLeave";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }


  public String getNameOf( AgentList<?> aolist ) {
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }


  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Source<Agent> instantiate_letInCustomers_xjal() {
    com.anylogic.libraries.processmodeling.Source<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Source<Agent>( getEngine(), this, null ) {
      @Override
      public double interarrivalTime(  ) {
        return _letInCustomers_interarrivalTime_xjal( this );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_interarrivalTime() {
        return MINUTE;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_letInCustomers_xjal( final com.anylogic.libraries.processmodeling.Source<Agent> self, TableInput _t ) {
    self.arrivalType = 
self.INTERARRIVAL_TIME 
;
    self.rate = self._rate_DefaultValue_xjal();
    self.firstArrivalMode = self._firstArrivalMode_DefaultValue_xjal();
    self.firstArrivalTime = self._firstArrivalTime_DefaultValue_xjal();
    self.rateSchedule = self._rateSchedule_DefaultValue_xjal();
    self.modifyRate = self._modifyRate_DefaultValue_xjal();
    self.arrivalSchedule = self._arrivalSchedule_DefaultValue_xjal();
    self.setAgentParametersFromDB = self._setAgentParametersFromDB_DefaultValue_xjal();
    self.databaseTable = self._databaseTable_DefaultValue_xjal();
    self.multipleEntitiesPerArrival = self._multipleEntitiesPerArrival_DefaultValue_xjal();
    self.limitArrivals = self._limitArrivals_DefaultValue_xjal();
    self.maxArrivals = self._maxArrivals_DefaultValue_xjal();
    self.locationType = self._locationType_DefaultValue_xjal();
    self.locationXYZInNetwork = self._locationXYZInNetwork_DefaultValue_xjal();
    self.enableCustomStartTime = self._enableCustomStartTime_DefaultValue_xjal();
    self.startTime = self._startTime_DefaultValue_xjal();
    self.addToCustomPopulation = self._addToCustomPopulation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.discardHangingEntities = self._discardHangingEntities_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_letInCustomers_xjal( com.anylogic.libraries.processmodeling.Source<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Seize<Agent> instantiate_seizeCustomer_xjal() {
    com.anylogic.libraries.processmodeling.Seize<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Seize<Agent>( getEngine(), this, null ) {
      @Override
      public com.anylogic.libraries.processmodeling.ResourcePool resourcePool( Agent agent ) {
        return _seizeCustomer_resourcePool_xjal( this, agent );
      }
      @Override
      public void onEnter( Agent agent ) {
        _seizeCustomer_onEnter_xjal( this, agent );
      }
      @Override
      public void onExit( Agent agent ) {
        _seizeCustomer_onExit_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_seizeCustomer_xjal( final com.anylogic.libraries.processmodeling.Seize<Agent> self, TableInput _t ) {
    self.seizeFromOnePool = 
true 
;
    self.seizePolicy = self._seizePolicy_DefaultValue_xjal();
    self.capacity = self._capacity_DefaultValue_xjal();
    self.maximumCapacity = 
true 
;
    self.destinationType = self._destinationType_DefaultValue_xjal();
    self.entityLocationQueue = self._entityLocationQueue_DefaultValue_xjal();
    self.terminatedTaskProcessing = self._terminatedTaskProcessing_DefaultValue_xjal();
    self.suspendResumeEntities = self._suspendResumeEntities_DefaultValue_xjal();
    self.customizeResourceChoice = self._customizeResourceChoice_DefaultValue_xjal();
    self.taskStartBlocksAreConnected = self._taskStartBlocksAreConnected_DefaultValue_xjal();
    self.taskStartBlocks = self._taskStartBlocks_DefaultValue_xjal();
    self.enableTimeout = self._enableTimeout_DefaultValue_xjal();
    self.enablePreemption = self._enablePreemption_DefaultValue_xjal();
    self.canceledUnitsBehavior = self._canceledUnitsBehavior_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.restoreEntityLocationOnExit = self._restoreEntityLocationOnExit_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_seizeCustomer_xjal( com.anylogic.libraries.processmodeling.Seize<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Agent> instantiate_handleCustomer_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Agent>( getEngine(), this, null ) {
      @Override
      public double delayTime( Agent agent ) {
        return _handleCustomer_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return MINUTE;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_handleCustomer_xjal( final com.anylogic.libraries.processmodeling.Delay<Agent> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
    self.capacity = self._capacity_DefaultValue_xjal();
    self.maximumCapacity = 
true 
;
    self.entityLocation = self._entityLocation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
    self.restoreEntityLocationOnExit = self._restoreEntityLocationOnExit_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_handleCustomer_xjal( com.anylogic.libraries.processmodeling.Delay<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Release<Agent> instantiate_releaseCustomer_xjal() {
    com.anylogic.libraries.processmodeling.Release<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Release<Agent>( getEngine(), this, null ) {
      @Override
      public com.anylogic.libraries.processmodeling.ResourcePool[] resources( Agent agent ) {
        return _releaseCustomer_resources_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_releaseCustomer_xjal( final com.anylogic.libraries.processmodeling.Release<Agent> self, TableInput _t ) {
    self.releaseMode = 
self.ALL_FROM_POOLS 
;
    self.seizeBlocks = self._seizeBlocks_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_releaseCustomer_xjal( com.anylogic.libraries.processmodeling.Release<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.ResourcePool<Agent> instantiate_Tellers_xjal() {
    com.anylogic.libraries.processmodeling.ResourcePool<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.ResourcePool<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_Tellers_xjal( final com.anylogic.libraries.processmodeling.ResourcePool<Agent> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
    self.capacityDefinitionType = self._capacityDefinitionType_DefaultValue_xjal();
    self.capacity = 
tellerCapacityNotBusy 
;
    self.capacityBasedOnAttractors = self._capacityBasedOnAttractors_DefaultValue_xjal();
    self.capacitySchedule = self._capacitySchedule_DefaultValue_xjal();
    self.capacityScheduleOnOff = self._capacityScheduleOnOff_DefaultValue_xjal();
    self.shiftGroupSchedules = self._shiftGroupSchedules_DefaultValue_xjal();
    self.shiftGroupSizes = self._shiftGroupSizes_DefaultValue_xjal();
    self.shiftGroupsPlan = self._shiftGroupsPlan_DefaultValue_xjal();
    self.destroyExcessUnits = self._destroyExcessUnits_DefaultValue_xjal();
    self.speed = self._speed_DefaultValue_xjal();
    self.homeNodes = self._homeNodes_DefaultValue_xjal();
    self.showDefaultAnimationStatic = self._showDefaultAnimationStatic_DefaultValue_xjal();
    self.downtimeSource = self._downtimeSource_DefaultValue_xjal();
    self.downtimeList = self._downtimeList_DefaultValue_xjal();
    self.enableMaintenance = self._enableMaintenance_DefaultValue_xjal();
    self.maintenanceType = self._maintenanceType_DefaultValue_xjal();
    self.enableFailuresRepairs = self._enableFailuresRepairs_DefaultValue_xjal();
    self.countBusyOnlyTimeToFailure = self._countBusyOnlyTimeToFailure_DefaultValue_xjal();
    self.repairType = self._repairType_DefaultValue_xjal();
    self.enableBreaks = self._enableBreaks_DefaultValue_xjal();
    self.breaksSchedule = self._breaksSchedule_DefaultValue_xjal();
    self.enableCustomTasks = self._enableCustomTasks_DefaultValue_xjal();
    self.customTasks = self._customTasks_DefaultValue_xjal();
    self.customizeRequestChoice = self._customizeRequestChoice_DefaultValue_xjal();
    self.addToCustomPopulation = self._addToCustomPopulation_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_Tellers_xjal( com.anylogic.libraries.processmodeling.ResourcePool<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Sink<Agent> instantiate_customerLeave_xjal() {
    com.anylogic.libraries.processmodeling.Sink<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Sink<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_customerLeave_xjal( final com.anylogic.libraries.processmodeling.Sink<Agent> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_customerLeave_xjal( com.anylogic.libraries.processmodeling.Sink<Agent> self, TableInput _t ) {
  }

  private double _letInCustomers_interarrivalTime_xjal( final com.anylogic.libraries.processmodeling.Source<Agent> self ) {
    double _value;
    _value = 
IAT 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private com.anylogic.libraries.processmodeling.ResourcePool _seizeCustomer_resourcePool_xjal( final com.anylogic.libraries.processmodeling.Seize<Agent> self, Agent agent ) {
    com.anylogic.libraries.processmodeling.ResourcePool _value;
    _value = 
Tellers 
;
    return _value;
  }
  private void _seizeCustomer_onEnter_xjal( final com.anylogic.libraries.processmodeling.Seize<Agent> self, Agent agent ) {
    
nQueue++;
statisticsQueue.add(nQueue, time()); 
;
  }
  private void _seizeCustomer_onExit_xjal( final com.anylogic.libraries.processmodeling.Seize<Agent> self, Agent agent ) {
    
nQueue--;
statisticsQueue.add(nQueue, time()); 
;
  }
  private double _handleCustomer_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Agent> self, Agent agent ) {
    double _value;
    _value = 
12 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private com.anylogic.libraries.processmodeling.ResourcePool[] _releaseCustomer_resources_xjal( final com.anylogic.libraries.processmodeling.Release<Agent> self, Agent agent ) {
    com.anylogic.libraries.processmodeling.ResourcePool[] _value;
    _value = new com.anylogic.libraries.processmodeling.ResourcePool[]
{ Tellers } 
;
    return _value;
  }
  // Functions

  
int 
 getTotalCost(  ) { 

return overheadOutput + salaryOutput; 
  }
  // Analysis Data Elements
  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression0_dataSet_xjal = new DataSet( 10000, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression0_dataSet_xjal_YValue() {
    return 
seizeCustomer.size() 
;
  }

  public StatisticsContinuous statisticsQueue = new StatisticsContinuous();
  
  public int overheadOutput;
  public void update_overheadOutput() {
    overheadOutput = 
overhead ;
  }
  public void update_overheadOutput(int _value) {
    overheadOutput = _value;
  }

  public int salaryOutput;
  public void update_salaryOutput() {
    salaryOutput = 
salary ;
  }
  public void update_salaryOutput(int _value) {
    salaryOutput = _value;
  }

  // View areas
  public ViewArea modelParameters = new ViewArea( this, "modelParameters", 1050, 0, 1000, 600 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "modelParameters", this.modelParameters );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _operatingCosts_Font = new Font("Arial Narrow", 1, 20 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary_Font = new Font("Arial Narrow", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary1_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary2_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary3_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary4_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary5_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _operatingCosts1_Font = _operatingCosts_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary6_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary7_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary8_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary9_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _Salary10_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = _Salary_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle2 = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle1 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _operatingCosts = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary1 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary2 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary3 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary4 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary5 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle3 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _operatingCosts1 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle4 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary6 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary7 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary8 = 26;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary9 = 27;
  @AnyLogicInternalCodegenAPI
  protected static final int _Salary10 = 28;
  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = 29;
  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = 30;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 31;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(roundRectangle2, roundRectangle, plot, roundRectangle1, operatingCosts, Salary, Salary1, Salary2, Salary3, Salary4, Salary5, roundRectangle3, operatingCosts1, text, text1, text2, roundRectangle4, text3, line, text4, text5, text6, text7, Salary6, Salary7, Salary8, Salary9, Salary10, text8, text9);
  }

  protected TimePlot plot;
  protected ShapeRoundedRectangle roundRectangle2;
  protected ShapeRoundedRectangle roundRectangle;
  protected ShapeRoundedRectangle roundRectangle1;
  protected ShapeText operatingCosts;
  protected ShapeText Salary;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _Salary1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
salary 
);
  }
  
  protected ShapeText Salary1;
  protected ShapeText Salary2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _Salary3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
overhead 
);
  }
  
  protected ShapeText Salary3;
  protected ShapeText Salary4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _Salary5_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
salary + overhead 
);
  }
  
  protected ShapeText Salary5;
  protected ShapeRoundedRectangle roundRectangle3;
  protected ShapeText operatingCosts1;
  protected ShapeText text;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
statisticsQueue.mean() 
);
  }
  
  protected ShapeText text1;
  protected ShapeText text2;
  protected ShapeRoundedRectangle roundRectangle4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
Tellers.utilization() 
);
  }
  
  protected ShapeText text3;
  protected ShapeLine line;
  protected ShapeText text4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text5_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
utilizationBeforeBusy 
);
  }
  
  protected ShapeText text5;
  protected ShapeText text6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text7_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
customerLeave.in.count() 
);
  }
  
  protected ShapeText text7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _Salary6_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
salary / Tellers.capacity 
);
  }
  
  protected ShapeText Salary6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _Salary7_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
overhead / Tellers.capacity 
);
  }
  
  protected ShapeText Salary7;
  protected ShapeText Salary8;
  protected ShapeText Salary9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _Salary10_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
salary / Tellers.capacity + overhead / Tellers.capacity 
);
  }
  
  protected ShapeText Salary10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text8_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
statisticsQueue.max() 
);
  }
  
  protected ShapeText text8;
  protected ShapeText text9;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    roundRectangle2 = new ShapeRoundedRectangle(
		true,370.0, 330.0, 0.0, 
        black, white,
		280.0, 220.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    roundRectangle = new ShapeRoundedRectangle(
		true,1110.0, 50.0, 0.0, 
        black, lavender,
		200.0, 170.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    roundRectangle1 = new ShapeRoundedRectangle(
		true,1110.0, 240.0, 0.0, 
        black, lavender,
		200.0, 210.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    operatingCosts = new ShapeText(
        SHAPE_DRAW_2D, true,450.0, 340.0, 0.0, 0.0, 
        black,"Operating Costs",
        _operatingCosts_Font, ALIGNMENT_LEFT );

    Salary = new ShapeText(
        SHAPE_DRAW_2D, true,390.0, 420.0, 0.0, 0.0, 
        black,"Salary",
        _Salary_Font, ALIGNMENT_LEFT );

    Salary1 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 420.0, 0.0, 0.0, 
        black,"",
        _Salary1_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _Salary1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    Salary2 = new ShapeText(
        SHAPE_DRAW_2D, true,390.0, 440.0, 0.0, 0.0, 
        black,"Overhead",
        _Salary2_Font, ALIGNMENT_LEFT );

    Salary3 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 440.0, 0.0, 0.0, 
        black,"",
        _Salary3_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _Salary3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    Salary4 = new ShapeText(
        SHAPE_DRAW_2D, true,390.0, 480.0, 0.0, 0.0, 
        black,"Total cost",
        _Salary4_Font, ALIGNMENT_LEFT );

    Salary5 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 480.0, 0.0, 0.0, 
        black,"sal",
        _Salary5_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _Salary5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    roundRectangle3 = new ShapeRoundedRectangle(
		true,700.0, 330.0, 0.0, 
        black, white,
		250.0, 220.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    operatingCosts1 = new ShapeText(
        SHAPE_DRAW_2D, true,730.0, 340.0, 0.0, 0.0, 
        black,"Operating Performance",
        _operatingCosts1_Font, ALIGNMENT_LEFT );

    text = new ShapeText(
        SHAPE_DRAW_2D, true,720.0, 420.0, 0.0, 0.0, 
        black,"Average queue length",
        _text_Font, ALIGNMENT_LEFT );

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, 420.0, 0.0, 0.0, 
        black,"",
        _text1_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,720.0, 460.0, 0.0, 0.0, 
        black,"Utilization of tellers",
        _text2_Font, ALIGNMENT_LEFT );

    roundRectangle4 = new ShapeRoundedRectangle(
		true,1110.0, 470.0, 0.0, 
        black, lavender,
		200.0, 90.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, 460.0, 0.0, 0.0, 
        black,"",
        _text3_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 390.0, 500.0, 0.0, black, 
 		230.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID );

    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,720.0, 480.0, 0.0, 0.0, 
        black,"Utilization before busy hours",
        _text4_Font, ALIGNMENT_LEFT );

    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, 480.0, 0.0, 0.0, 
        black,"",
        _text5_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,720.0, 500.0, 0.0, 0.0, 
        black,"Total customers processed",
        _text6_Font, ALIGNMENT_LEFT );

    text7 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, 500.0, 0.0, 0.0, 
        black,"",
        _text7_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    Salary6 = new ShapeText(
        SHAPE_DRAW_2D, true,569.0, 420.0, 0.0, 0.0, 
        black,"",
        _Salary6_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _Salary6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    Salary7 = new ShapeText(
        SHAPE_DRAW_2D, true,570.0, 440.0, 0.0, 0.0, 
        black,"",
        _Salary7_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _Salary7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    Salary8 = new ShapeText(
        SHAPE_DRAW_2D, true,500.0, 390.0, 0.0, 0.0, 
        black,"Cost",
        _Salary8_Font, ALIGNMENT_LEFT );

    Salary9 = new ShapeText(
        SHAPE_DRAW_2D, true,570.0, 390.0, 0.0, 0.0, 
        black,"Cost / teller",
        _Salary9_Font, ALIGNMENT_LEFT );

    Salary10 = new ShapeText(
        SHAPE_DRAW_2D, true,570.0, 480.0, 0.0, 0.0, 
        black,"sal",
        _Salary10_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _Salary10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text8 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, 440.0, 0.0, 0.0, 
        black,"",
        _text8_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text9 = new ShapeText(
        SHAPE_DRAW_2D, true,720.0, 440.0, 0.0, 0.0, 
        black,"Max observed queue length",
        _text9_Font, ALIGNMENT_LEFT );

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 1 );
    _items.add( _plot_expression0_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Queue length" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( black, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot = new TimePlot(
		    Scenario_AlterAtBusyHours.this, true, 30.0, 360.0, 
			300.0, 200.0,
            null, null,
            50.0, 30.0,
			220.0, 110.0, white, black, black,
            30.0, Chart.SOUTH,
            
8 
             * hour(), Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _appearances );

    }
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }


  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

	


  /**
   * Constructor
   */
  public Scenario_AlterAtBusyHours( Engine engine, Agent owner, AgentList<? extends Scenario_AlterAtBusyHours> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    letInCustomers = instantiate_letInCustomers_xjal();
    seizeCustomer = instantiate_seizeCustomer_xjal();
    handleCustomer = instantiate_handleCustomer_xjal();
    releaseCustomer = instantiate_releaseCustomer_xjal();
    Tellers = instantiate_Tellers_xjal();
    customerLeave = instantiate_customerLeave_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Scenario_AlterAtBusyHours() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Scenario_AlterAtBusyHours( double IAT, int hrCostTeller, int overhead, int tellerCapacityNotBusy, int tellerCapacityBusy ) {
    markParametersAreSet();
    this.IAT = IAT;
    this.hrCostTeller = hrCostTeller;
    this.overhead = overhead;
    this.tellerCapacityNotBusy = tellerCapacityNotBusy;
    this.tellerCapacityBusy = tellerCapacityBusy;
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Scenario_AlterAtBusyHours_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Scenario_AlterAtBusyHours.this, true, 0, 0, 0, 0 , level );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Scenario_AlterAtBusyHours.this, getElementProperty( "staffingOptimization.Scenario_AlterAtBusyHours.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Creating non-replicated embedded objects
    setupParameters_letInCustomers_xjal( letInCustomers, null );
    doBeforeCreate_letInCustomers_xjal( letInCustomers, null );
    letInCustomers.createAsEmbedded();
    setupParameters_seizeCustomer_xjal( seizeCustomer, null );
    doBeforeCreate_seizeCustomer_xjal( seizeCustomer, null );
    seizeCustomer.createAsEmbedded();
    setupParameters_handleCustomer_xjal( handleCustomer, null );
    doBeforeCreate_handleCustomer_xjal( handleCustomer, null );
    handleCustomer.createAsEmbedded();
    setupParameters_releaseCustomer_xjal( releaseCustomer, null );
    doBeforeCreate_releaseCustomer_xjal( releaseCustomer, null );
    releaseCustomer.createAsEmbedded();
    setupParameters_Tellers_xjal( Tellers, null );
    doBeforeCreate_Tellers_xjal( Tellers, null );
    Tellers.createAsEmbedded();
    setupParameters_customerLeave_xjal( customerLeave, null );
    doBeforeCreate_customerLeave_xjal( customerLeave, null );
    customerLeave.createAsEmbedded();
	 // Port connectors with non-replicated objects
    seizeCustomer.in.connect( letInCustomers.out ); // connector
    handleCustomer.in.connect( seizeCustomer.out ); // connector1
    releaseCustomer.in.connect( handleCustomer.out ); // connector2
    customerLeave.in.connect( releaseCustomer.out ); // connector3
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Scenario_AlterAtBusyHours.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    triggerBusyHours.start();
    incrementHrSalary.start();
    _statisticsQueue_autoUpdateEvent_xjal.start();
    _plot_autoUpdateEvent_xjal.start();
    letInCustomers.startAsEmbedded();
    seizeCustomer.startAsEmbedded();
    handleCustomer.startAsEmbedded();
    releaseCustomer.startAsEmbedded();
    Tellers.startAsEmbedded();
    customerLeave.startAsEmbedded();
  }
 

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Scenario_AlterAtBusyHours_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Scenario_AlterAtBusyHours_xjal() {
    salary = 
0 
;
    utilizationBeforeBusy = 
0 
;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }


  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<Object>();
    }
    list.add( letInCustomers );
    list.add( seizeCustomer );
    list.add( handleCustomer );
    list.add( releaseCustomer );
    list.add( Tellers );
    list.add( customerLeave );
    return list;
  }

  public AgentList<? extends Scenario_AlterAtBusyHours> getPopulation() {
    return (AgentList<? extends Scenario_AlterAtBusyHours>) super.getPopulation();
  }

  public List<? extends Scenario_AlterAtBusyHours> agentsInRange( double distance ) {
    return (List<? extends Scenario_AlterAtBusyHours>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _statisticsQueue_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    triggerBusyHours.onDestroy();
    incrementHrSalary.onDestroy();
    _statisticsQueue_autoUpdateEvent_xjal.onDestroy();
    _plot_autoUpdateEvent_xjal.onDestroy();
    letInCustomers.onDestroy();
    seizeCustomer.onDestroy();
    handleCustomer.onDestroy();
    releaseCustomer.onDestroy();
    Tellers.onDestroy();
    customerLeave.onDestroy();
  // Analysis Data Elements
    _plot_expression0_dataSet_xjal.destroyUpdater_xjal();
    statisticsQueue.destroyUpdater_xjal();
    logToDB( statisticsQueue, "statisticsQueue" );
    logToDB( _plot_expression0_dataSet_xjal, "plot : Queue length" );
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    letInCustomers.doFinish();
    seizeCustomer.doFinish();
    handleCustomer.doFinish();
    releaseCustomer.doFinish();
    Tellers.doFinish();
    customerLeave.doFinish();
    update_overheadOutput();
    update_salaryOutput();
  }



}
