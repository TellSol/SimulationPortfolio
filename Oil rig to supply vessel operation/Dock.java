package agentmodelling;

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

import com.querydsl.core.Tuple;
import com.querydsl.sql.SQLBindings;
import static agentmodelling.DBDescriptor.*;

import java.awt.geom.Arc2D;

import com.google.common.cache.LoadingCache; 

public class Dock extends Agent
{
  // Parameters
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Dock.class );
  
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



	

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  public com.anylogic.libraries.processmodeling.ResourcePool<
Truck 
> vessels;
  public com.anylogic.libraries.processmodeling.Enter<
Order 
> enter;
  public com.anylogic.libraries.processmodeling.Seize<
Order 
> seize;
  public com.anylogic.libraries.processmodeling.ResourceTaskStart<
Truck 
> resourceTaskStart;
  public com.anylogic.libraries.processmodeling.Delay<
Truck 
> loading;
  public com.anylogic.libraries.processmodeling.MoveTo<
Truck 
> toOilRig;
  public com.anylogic.libraries.processmodeling.Delay<
Order 
> unloading;
  public com.anylogic.libraries.processmodeling.Release<
Order 
> release;
  public com.anylogic.libraries.processmodeling.Sink<
Order 
> sink;
  public com.anylogic.libraries.processmodeling.MoveTo<
Truck 
> returnToDock;
  public com.anylogic.libraries.processmodeling.ResourceTaskEnd<
Truck 
> resourceTaskEnd;
  public com.anylogic.libraries.processmodeling.TimeMeasureStart<
Truck 
> MissionTimeStart;
  public com.anylogic.libraries.processmodeling.TimeMeasureEnd<
Truck 
> MissionTimeEnd;
  public com.anylogic.libraries.processmodeling.TimeMeasureStart<
Truck 
> LeadTimeStart;
  public com.anylogic.libraries.processmodeling.TimeMeasureEnd<
Truck 
> LeadTimeEnd;

  public String getNameOf( Agent ao ) {
    if ( ao == vessels ) return "vessels";
    if ( ao == enter ) return "enter";
    if ( ao == seize ) return "seize";
    if ( ao == resourceTaskStart ) return "resourceTaskStart";
    if ( ao == loading ) return "loading";
    if ( ao == toOilRig ) return "toOilRig";
    if ( ao == unloading ) return "unloading";
    if ( ao == release ) return "release";
    if ( ao == sink ) return "sink";
    if ( ao == returnToDock ) return "returnToDock";
    if ( ao == resourceTaskEnd ) return "resourceTaskEnd";
    if ( ao == MissionTimeStart ) return "MissionTimeStart";
    if ( ao == MissionTimeEnd ) return "MissionTimeEnd";
    if ( ao == LeadTimeStart ) return "LeadTimeStart";
    if ( ao == LeadTimeEnd ) return "LeadTimeEnd";
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
  protected com.anylogic.libraries.processmodeling.ResourcePool<Truck> instantiate_vessels_xjal() {
    com.anylogic.libraries.processmodeling.ResourcePool<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.ResourcePool<Truck>( getEngine(), this, null ) {
      @Override
      public Agent newUnit(  ) {
        return _vessels_newUnit_xjal( this );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_speed() {
        return KN;
      }
      @Override
      public AgentList population( Truck unit ) {
        return _vessels_population_xjal( this, unit );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_vessels_xjal( final com.anylogic.libraries.processmodeling.ResourcePool<Truck> self, TableInput _t ) {
    self.type = self._type_DefaultValue_xjal();
    self.capacityDefinitionType = self._capacityDefinitionType_DefaultValue_xjal();
    self.capacity = 
baselineScenario.NumerOfVessels 
;
    self.capacityBasedOnAttractors = self._capacityBasedOnAttractors_DefaultValue_xjal();
    self.capacitySchedule = self._capacitySchedule_DefaultValue_xjal();
    self.capacityScheduleOnOff = self._capacityScheduleOnOff_DefaultValue_xjal();
    self.shiftGroupSchedules = self._shiftGroupSchedules_DefaultValue_xjal();
    self.shiftGroupSizes = self._shiftGroupSizes_DefaultValue_xjal();
    self.shiftGroupsPlan = self._shiftGroupsPlan_DefaultValue_xjal();
    self.destroyExcessUnits = self._destroyExcessUnits_DefaultValue_xjal();
    self.speed = 
normal(30, 40) 
;
    self.speed = KN.convertTo( self.speed, MPS );
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
    self.addToCustomPopulation = 
true 
;
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_vessels_xjal( com.anylogic.libraries.processmodeling.ResourcePool<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Enter<Order> instantiate_enter_xjal() {
    com.anylogic.libraries.processmodeling.Enter<Order> _result_xjal = new com.anylogic.libraries.processmodeling.Enter<Order>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_enter_xjal( final com.anylogic.libraries.processmodeling.Enter<Order> self, TableInput _t ) {
    self.locationType = self._locationType_DefaultValue_xjal();
    self.locationXYZInNetwork = self._locationXYZInNetwork_DefaultValue_xjal();
    self.addToCustomPopulation = self._addToCustomPopulation_DefaultValue_xjal();
    self.pushProtocol = self._pushProtocol_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_enter_xjal( com.anylogic.libraries.processmodeling.Enter<Order> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Seize<Order> instantiate_seize_xjal() {
    com.anylogic.libraries.processmodeling.Seize<Order> _result_xjal = new com.anylogic.libraries.processmodeling.Seize<Order>( getEngine(), this, null ) {
      @Override
      public com.anylogic.libraries.processmodeling.ResourcePool[][] resourceSets( Order agent ) {
        return _seize_resourceSets_xjal( this, agent );
      }
      @Override
      public void onSeizeUnit( Order agent, Agent unit ) {
        _seize_onSeizeUnit_xjal( this, agent, unit );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_seize_xjal( final com.anylogic.libraries.processmodeling.Seize<Order> self, TableInput _t ) {
    self.seizeFromOnePool = self._seizeFromOnePool_DefaultValue_xjal();
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
  private void doBeforeCreate_seize_xjal( com.anylogic.libraries.processmodeling.Seize<Order> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.ResourceTaskStart<Truck> instantiate_resourceTaskStart_xjal() {
    com.anylogic.libraries.processmodeling.ResourceTaskStart<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.ResourceTaskStart<Truck>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_resourceTaskStart_xjal( final com.anylogic.libraries.processmodeling.ResourceTaskStart<Truck> self, TableInput _t ) {
    self.defaultUnitsStart = self._defaultUnitsStart_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_resourceTaskStart_xjal( com.anylogic.libraries.processmodeling.ResourceTaskStart<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Truck> instantiate_loading_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Truck>( getEngine(), this, null ) {
      @Override
      public double delayTime( Truck agent ) {
        return _loading_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return HOUR;
      }
      @Override
      public void onExit( Truck agent ) {
        _loading_onExit_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_loading_xjal( final com.anylogic.libraries.processmodeling.Delay<Truck> self, TableInput _t ) {
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
  private void doBeforeCreate_loading_xjal( com.anylogic.libraries.processmodeling.Delay<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.MoveTo<Truck> instantiate_toOilRig_xjal() {
    com.anylogic.libraries.processmodeling.MoveTo<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.MoveTo<Truck>( getEngine(), this, null ) {
      @Override
      public Agent destinationAgent( Truck agent ) {
        return _toOilRig_destinationAgent_xjal( this, agent );
      }
      @Override
      public com.anylogic.libraries.processmodeling.MoveTo.MovementType movementType( Truck agent ) {
        return _toOilRig_movementType_xjal( this, agent );
      }
      @Override
      public double tripTime( Truck agent ) {
        return _toOilRig_tripTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_tripTime() {
        return DAY;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_toOilRig_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.destinationType = 
self.DEST_AGENT 
;
    self.destinationInNetwork = self._destinationInNetwork_DefaultValue_xjal();
    self.useOffsets = self._useOffsets_DefaultValue_xjal();
    self.straightMovement = self._straightMovement_DefaultValue_xjal();
    self.destinationUseRotation = self._destinationUseRotation_DefaultValue_xjal();
    self.restoreSpeedOnArrival = self._restoreSpeedOnArrival_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_toOilRig_xjal( com.anylogic.libraries.processmodeling.MoveTo<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Order> instantiate_unloading_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Order> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Order>( getEngine(), this, null ) {
      @Override
      public double delayTime( Order agent ) {
        return _unloading_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return HOUR;
      }
      @Override
      public void onExit( Order agent ) {
        _unloading_onExit_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_unloading_xjal( final com.anylogic.libraries.processmodeling.Delay<Order> self, TableInput _t ) {
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
  private void doBeforeCreate_unloading_xjal( com.anylogic.libraries.processmodeling.Delay<Order> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Release<Order> instantiate_release_xjal() {
    com.anylogic.libraries.processmodeling.Release<Order> _result_xjal = new com.anylogic.libraries.processmodeling.Release<Order>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_release_xjal( final com.anylogic.libraries.processmodeling.Release<Order> self, TableInput _t ) {
    self.releaseMode = self._releaseMode_DefaultValue_xjal();
    self.seizeBlocks = self._seizeBlocks_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_release_xjal( com.anylogic.libraries.processmodeling.Release<Order> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Sink<Order> instantiate_sink_xjal() {
    com.anylogic.libraries.processmodeling.Sink<Order> _result_xjal = new com.anylogic.libraries.processmodeling.Sink<Order>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_sink_xjal( final com.anylogic.libraries.processmodeling.Sink<Order> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_sink_xjal( com.anylogic.libraries.processmodeling.Sink<Order> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.MoveTo<Truck> instantiate_returnToDock_xjal() {
    com.anylogic.libraries.processmodeling.MoveTo<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.MoveTo<Truck>( getEngine(), this, null ) {
      @Override
      public Agent destinationAgent( Truck agent ) {
        return _returnToDock_destinationAgent_xjal( this, agent );
      }
      @Override
      public com.anylogic.libraries.processmodeling.MoveTo.MovementType movementType( Truck agent ) {
        return _returnToDock_movementType_xjal( this, agent );
      }
      @Override
      public double tripTime( Truck agent ) {
        return _returnToDock_tripTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_tripTime() {
        return DAY;
      }
      @Override
      public void onEnter( Truck agent ) {
        _returnToDock_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_returnToDock_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.destinationType = 
self.DEST_AGENT 
;
    self.destinationInNetwork = self._destinationInNetwork_DefaultValue_xjal();
    self.useOffsets = self._useOffsets_DefaultValue_xjal();
    self.straightMovement = self._straightMovement_DefaultValue_xjal();
    self.destinationUseRotation = self._destinationUseRotation_DefaultValue_xjal();
    self.restoreSpeedOnArrival = self._restoreSpeedOnArrival_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_returnToDock_xjal( com.anylogic.libraries.processmodeling.MoveTo<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.ResourceTaskEnd<Truck> instantiate_resourceTaskEnd_xjal() {
    com.anylogic.libraries.processmodeling.ResourceTaskEnd<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.ResourceTaskEnd<Truck>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_resourceTaskEnd_xjal( final com.anylogic.libraries.processmodeling.ResourceTaskEnd<Truck> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_resourceTaskEnd_xjal( com.anylogic.libraries.processmodeling.ResourceTaskEnd<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> instantiate_MissionTimeStart_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_MissionTimeStart_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_MissionTimeStart_xjal( com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> instantiate_MissionTimeEnd_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_MissionTimeEnd_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> self, TableInput _t ) {
    self.startObjects = new com.anylogic.libraries.processmodeling.TimeMeasureStart[]
{ MissionTimeStart } 
;
    self.datasetCapacity = 
1000 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_MissionTimeEnd_xjal( com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> instantiate_LeadTimeStart_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_LeadTimeStart_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_LeadTimeStart_xjal( com.anylogic.libraries.processmodeling.TimeMeasureStart<Truck> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> instantiate_LeadTimeEnd_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_LeadTimeEnd_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> self, TableInput _t ) {
    self.startObjects = new com.anylogic.libraries.processmodeling.TimeMeasureStart[]
{ LeadTimeStart } 
;
    self.datasetCapacity = 
1000 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_LeadTimeEnd_xjal( com.anylogic.libraries.processmodeling.TimeMeasureEnd<Truck> self, TableInput _t ) {
  }

  private Agent _vessels_newUnit_xjal( final com.anylogic.libraries.processmodeling.ResourcePool<Truck> self ) {
    Agent _value;
    _value = 
new agentmodelling.Truck() 
;
    return _value;
  }
  private AgentList _vessels_population_xjal( final com.anylogic.libraries.processmodeling.ResourcePool<Truck> self, Truck unit ) {
    AgentList _value;
    _value = 
baselineScenario.vessels 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.ResourcePool[][] _seize_resourceSets_xjal( final com.anylogic.libraries.processmodeling.Seize<Order> self, Order agent ) {
    com.anylogic.libraries.processmodeling.ResourcePool[][] _value;
    _value = new com.anylogic.libraries.processmodeling.ResourcePool[][]
{ 
  { vessels }
} 
;
    return _value;
  }
  private void _seize_onSeizeUnit_xjal( final com.anylogic.libraries.processmodeling.Seize<Order> self, Order agent, Agent unit ) {
    
((Truck) unit).client = agent.customer; 
;
  }
  private double _loading_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Truck> self, Truck agent ) {
    double _value;
    _value = 
5 
;
    _value = HOUR.convertTo( _value, SECOND );
    return _value;
  }
  private void _loading_onExit_xjal( final com.anylogic.libraries.processmodeling.Delay<Truck> self, Truck agent ) {
    
agent.ballast += agent.loadingCap; 
;
  }
  private Agent _toOilRig_destinationAgent_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    Agent _value;
    _value = 
agent.client 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.MoveTo.MovementType _toOilRig_movementType_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    com.anylogic.libraries.processmodeling.MoveTo.MovementType _value;
    _value = 
self.MOVE_TRIP_TIME 
;
    return _value;
  }
  private double _toOilRig_tripTime_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    double _value;
    _value = 
1 
;
    _value = DAY.convertTo( _value, SECOND );
    return _value;
  }
  private double _unloading_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Order> self, Order agent ) {
    double _value;
    _value = 
5 
;
    _value = HOUR.convertTo( _value, SECOND );
    return _value;
  }
  private void _unloading_onExit_xjal( final com.anylogic.libraries.processmodeling.Delay<Order> self, Order agent ) {
    
send("delivered", agent.customer); 
;
  }
  private Agent _returnToDock_destinationAgent_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    Agent _value;
    _value = 
baselineScenario.dock 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.MoveTo.MovementType _returnToDock_movementType_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    com.anylogic.libraries.processmodeling.MoveTo.MovementType _value;
    _value = 
self.MOVE_TRIP_TIME 
;
    return _value;
  }
  private double _returnToDock_tripTime_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    double _value;
    _value = 
1 
;
    _value = DAY.convertTo( _value, SECOND );
    return _value;
  }
  private void _returnToDock_onEnter_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Truck> self, Truck agent ) {
    
agent.ballast -= agent.loadingCap; 
;
  }
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1450.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final int _image = 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 2;

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
	  level.addAll(image);
  }

  protected ShapeImage image;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    image = new ShapeImage(
		Dock.this, SHAPE_DRAW_2D3D, true, -12.2, -17.0, 0.0, 0.0, 
			25.0, 25.0, "/agentmodelling/", 
			new String[]{"warehouse.png",}	 );

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
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
  public Dock( Engine engine, Agent owner, AgentList<? extends Dock> ownerPopulation ) {
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
    vessels = instantiate_vessels_xjal();
    enter = instantiate_enter_xjal();
    seize = instantiate_seize_xjal();
    resourceTaskStart = instantiate_resourceTaskStart_xjal();
    loading = instantiate_loading_xjal();
    toOilRig = instantiate_toOilRig_xjal();
    unloading = instantiate_unloading_xjal();
    release = instantiate_release_xjal();
    sink = instantiate_sink_xjal();
    returnToDock = instantiate_returnToDock_xjal();
    resourceTaskEnd = instantiate_resourceTaskEnd_xjal();
    MissionTimeStart = instantiate_MissionTimeStart_xjal();
    MissionTimeEnd = instantiate_MissionTimeEnd_xjal();
    LeadTimeStart = instantiate_LeadTimeStart_xjal();
    LeadTimeEnd = instantiate_LeadTimeEnd_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    baselineScenario = get_BaselineScenario();
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Dock() {
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
    setupPlainVariables_Dock_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Dock.this, true, 0, 0, 0, 0 , level );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Dock.this, getElementProperty( "agentmodelling.Dock.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Creating non-replicated embedded objects
    setupParameters_vessels_xjal( vessels, null );
    doBeforeCreate_vessels_xjal( vessels, null );
    vessels.createAsEmbedded();
    setupParameters_enter_xjal( enter, null );
    doBeforeCreate_enter_xjal( enter, null );
    enter.createAsEmbedded();
    setupParameters_seize_xjal( seize, null );
    doBeforeCreate_seize_xjal( seize, null );
    seize.createAsEmbedded();
    setupParameters_resourceTaskStart_xjal( resourceTaskStart, null );
    doBeforeCreate_resourceTaskStart_xjal( resourceTaskStart, null );
    resourceTaskStart.createAsEmbedded();
    setupParameters_loading_xjal( loading, null );
    doBeforeCreate_loading_xjal( loading, null );
    loading.createAsEmbedded();
    setupParameters_toOilRig_xjal( toOilRig, null );
    doBeforeCreate_toOilRig_xjal( toOilRig, null );
    toOilRig.createAsEmbedded();
    setupParameters_unloading_xjal( unloading, null );
    doBeforeCreate_unloading_xjal( unloading, null );
    unloading.createAsEmbedded();
    setupParameters_release_xjal( release, null );
    doBeforeCreate_release_xjal( release, null );
    release.createAsEmbedded();
    setupParameters_sink_xjal( sink, null );
    doBeforeCreate_sink_xjal( sink, null );
    sink.createAsEmbedded();
    setupParameters_returnToDock_xjal( returnToDock, null );
    doBeforeCreate_returnToDock_xjal( returnToDock, null );
    returnToDock.createAsEmbedded();
    setupParameters_resourceTaskEnd_xjal( resourceTaskEnd, null );
    doBeforeCreate_resourceTaskEnd_xjal( resourceTaskEnd, null );
    resourceTaskEnd.createAsEmbedded();
    setupParameters_MissionTimeStart_xjal( MissionTimeStart, null );
    doBeforeCreate_MissionTimeStart_xjal( MissionTimeStart, null );
    MissionTimeStart.createAsEmbedded();
    setupParameters_MissionTimeEnd_xjal( MissionTimeEnd, null );
    doBeforeCreate_MissionTimeEnd_xjal( MissionTimeEnd, null );
    MissionTimeEnd.createAsEmbedded();
    setupParameters_LeadTimeStart_xjal( LeadTimeStart, null );
    doBeforeCreate_LeadTimeStart_xjal( LeadTimeStart, null );
    LeadTimeStart.createAsEmbedded();
    setupParameters_LeadTimeEnd_xjal( LeadTimeEnd, null );
    doBeforeCreate_LeadTimeEnd_xjal( LeadTimeEnd, null );
    LeadTimeEnd.createAsEmbedded();
	 // Port connectors with non-replicated objects
    seize.in.connect( enter.out ); // connector
    toOilRig.in.connect( loading.out ); // connector2
    toOilRig.out.connect( seize.preparedUnits ); // connector3
    unloading.in.connect( seize.out ); // connector4
    sink.in.connect( release.out ); // connector6
    release.wrapUp.connect( LeadTimeEnd.in ); // connector7
    MissionTimeStart.in.connect( resourceTaskStart.out ); // connector1
    returnToDock.out.connect( MissionTimeEnd.in ); // connector8
    MissionTimeEnd.out.connect( resourceTaskEnd.in ); // connector10
    MissionTimeStart.out.connect( LeadTimeStart.in ); // connector9
    LeadTimeStart.out.connect( loading.in ); // connector11
    release.in.connect( unloading.out ); // connector12
    LeadTimeEnd.out.connect( returnToDock.in ); // connector5
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Dock.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    vessels.startAsEmbedded();
    enter.startAsEmbedded();
    seize.startAsEmbedded();
    resourceTaskStart.startAsEmbedded();
    loading.startAsEmbedded();
    toOilRig.startAsEmbedded();
    unloading.startAsEmbedded();
    release.startAsEmbedded();
    sink.startAsEmbedded();
    returnToDock.startAsEmbedded();
    resourceTaskEnd.startAsEmbedded();
    MissionTimeStart.startAsEmbedded();
    MissionTimeEnd.startAsEmbedded();
    LeadTimeStart.startAsEmbedded();
    LeadTimeEnd.startAsEmbedded();
  }
 

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Dock_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Dock_xjal() {
  }

  // User API -----------------------------------------------------
  public BaselineScenario get_BaselineScenario() {
    {
      Agent owner = getOwner();
      if ( owner instanceof BaselineScenario ) return (BaselineScenario) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient agentmodelling.BaselineScenario baselineScenario;

  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive( Object _msg_xjal, Agent _sender_xjal ) {
    super.onReceive( _msg_xjal, _sender_xjal );
    
Order  msg = (Order) _msg_xjal;
    Agent sender = _sender_xjal;
    
enter.take(msg); 
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
    list.add( vessels );
    list.add( enter );
    list.add( seize );
    list.add( resourceTaskStart );
    list.add( loading );
    list.add( toOilRig );
    list.add( unloading );
    list.add( release );
    list.add( sink );
    list.add( returnToDock );
    list.add( resourceTaskEnd );
    list.add( MissionTimeStart );
    list.add( MissionTimeEnd );
    list.add( LeadTimeStart );
    list.add( LeadTimeEnd );
    return list;
  }

  public AgentList<? extends Dock> getPopulation() {
    return (AgentList<? extends Dock>) super.getPopulation();
  }

  public List<? extends Dock> agentsInRange( double distance ) {
    return (List<? extends Dock>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    vessels.onDestroy();
    enter.onDestroy();
    seize.onDestroy();
    resourceTaskStart.onDestroy();
    loading.onDestroy();
    toOilRig.onDestroy();
    unloading.onDestroy();
    release.onDestroy();
    sink.onDestroy();
    returnToDock.onDestroy();
    resourceTaskEnd.onDestroy();
    MissionTimeStart.onDestroy();
    MissionTimeEnd.onDestroy();
    LeadTimeStart.onDestroy();
    LeadTimeEnd.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    vessels.doFinish();
    enter.doFinish();
    seize.doFinish();
    resourceTaskStart.doFinish();
    loading.doFinish();
    toOilRig.doFinish();
    unloading.doFinish();
    release.doFinish();
    sink.doFinish();
    returnToDock.doFinish();
    resourceTaskEnd.doFinish();
    MissionTimeStart.doFinish();
    MissionTimeEnd.doFinish();
    LeadTimeStart.doFinish();
    LeadTimeEnd.doFinish();
  }



}
