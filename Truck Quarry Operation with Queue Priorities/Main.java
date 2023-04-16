package truck_quarry_operation;

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

public class Main extends Agent
{
  // Parameters
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );
  
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

  public com.anylogic.libraries.processmodeling.Source<
Truck20T 
> source20t;
  public com.anylogic.libraries.processmodeling.Service<
Agent 
> service;
  public com.anylogic.libraries.processmodeling.MoveTo<
Agent 
> moveTo;
  public com.anylogic.libraries.processmodeling.Queue<
Agent 
> queue;
  public com.anylogic.libraries.processmodeling.Seize<
Agent 
> seize;
  public com.anylogic.libraries.processmodeling.Delay<
Agent 
> delay;
  public com.anylogic.libraries.processmodeling.Release<
Agent 
> release;
  public com.anylogic.libraries.processmodeling.Source<
Truck50T 
> source50t;
  public com.anylogic.libraries.processmodeling.Delay<
Truck20T 
> delay1;
  public com.anylogic.libraries.processmodeling.MoveTo<
Agent 
> moveTo1;
  public com.anylogic.libraries.processmodeling.ResourcePool<
Agent 
> shovel;
  public com.anylogic.libraries.processmodeling.ResourcePool<
Agent 
> crusher;
  public com.anylogic.libraries.processmodeling.Hold<
Agent 
> hold;
  public com.anylogic.libraries.processmodeling.PMLSettings pMLSettings;

  public String getNameOf( Agent ao ) {
    if ( ao == source20t ) return "source20t";
    if ( ao == service ) return "service";
    if ( ao == moveTo ) return "moveTo";
    if ( ao == queue ) return "queue";
    if ( ao == seize ) return "seize";
    if ( ao == delay ) return "delay";
    if ( ao == release ) return "release";
    if ( ao == source50t ) return "source50t";
    if ( ao == delay1 ) return "delay1";
    if ( ao == moveTo1 ) return "moveTo1";
    if ( ao == shovel ) return "shovel";
    if ( ao == crusher ) return "crusher";
    if ( ao == hold ) return "hold";
    if ( ao == pMLSettings ) return "pMLSettings";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }

  public class _truck20Ts_Population extends AgentArrayList<Truck20T> {
    _truck20Ts_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public Truck20T instantiateAgent( int index ) {
    	return instantiate_truck20Ts_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Truck20T agent, int index, TableInput tableInput ) {
      setupParameters_truck20Ts_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Truck20T agent, int index, TableInput tableInput ) {
      doBeforeCreate_truck20Ts_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Truck20T")
  public _truck20Ts_Population truck20Ts = new _truck20Ts_Population( this );
  public class _truck50Ts_Population extends AgentArrayList<Truck50T> {
    _truck50Ts_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public Truck50T instantiateAgent( int index ) {
    	return instantiate_truck50Ts_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Truck50T agent, int index, TableInput tableInput ) {
      setupParameters_truck50Ts_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Truck50T agent, int index, TableInput tableInput ) {
      doBeforeCreate_truck50Ts_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return false;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Truck50T")
  public _truck50Ts_Population truck50Ts = new _truck50Ts_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == truck20Ts ) return "truck20Ts";
    if( aolist == truck50Ts ) return "truck50Ts";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in truck20Ts
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Truck20T truck20Ts(int index) {
    return truck20Ts.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection truck20Ts<br>
   * @return newly created embedded object
   */
  public Truck20T add_truck20Ts() {
    int index = truck20Ts.size();
    Truck20T _result_xjal = instantiate_truck20Ts_xjal( index );
    truck20Ts.callSetupParameters( _result_xjal, index );
    truck20Ts.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection truck20Ts<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object truck20Ts - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to truck20Ts
   */
  public boolean remove_truck20Ts( Truck20T object ) {
    if( ! truck20Ts._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    return true;
  }
  /**
   * Returns the agent element at the specified position in truck50Ts
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Truck50T truck50Ts(int index) {
    return truck50Ts.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection truck50Ts<br>
   * @return newly created embedded object
   */
  public Truck50T add_truck50Ts() {
    int index = truck50Ts.size();
    Truck50T _result_xjal = instantiate_truck50Ts_xjal( index );
    truck50Ts.callSetupParameters( _result_xjal, index );
    truck50Ts.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection truck50Ts<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object truck50Ts - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to truck50Ts
   */
  public boolean remove_truck50Ts( Truck50T object ) {
    if( ! truck50Ts._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    return true;
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Truck20T instantiate_truck20Ts_xjal( final int index ) {
    Truck20T _result_xjal = new Truck20T( getEngine(), this, truck20Ts );
    
    truck20Ts._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_truck20Ts_xjal( final Truck20T self, final int index, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_truck20Ts_xjal( Truck20T self, final int index, TableInput _t ) {
    self.setEnvironment( this );

    // Port connections
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Truck50T instantiate_truck50Ts_xjal( final int index ) {
    Truck50T _result_xjal = new Truck50T( getEngine(), this, truck50Ts );
    
    truck50Ts._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_truck50Ts_xjal( final Truck50T self, final int index, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_truck50Ts_xjal( Truck50T self, final int index, TableInput _t ) {
    self.setEnvironment( this );

    // Port connections
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Source<Truck20T> instantiate_source20t_xjal() {
    com.anylogic.libraries.processmodeling.Source<Truck20T> _result_xjal = new com.anylogic.libraries.processmodeling.Source<Truck20T>( getEngine(), this, null ) {
      @Override
      public INode locationNode( Truck20T agent ) {
        return _source20t_locationNode_xjal( this, agent );
      }
      @Override
      public Agent newEntity(  ) {
        return _source20t_newEntity_xjal( this );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_source20t_xjal( final com.anylogic.libraries.processmodeling.Source<Truck20T> self, TableInput _t ) {
    self.arrivalType = 
self.MANUAL 
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
    self.locationType = 
self.LOCATION_NODE 
;
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
  private void doBeforeCreate_source20t_xjal( com.anylogic.libraries.processmodeling.Source<Truck20T> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Service<Agent> instantiate_service_xjal() {
    com.anylogic.libraries.processmodeling.Service<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Service<Agent>( getEngine(), this, null ) {
      @Override
      public com.anylogic.libraries.processmodeling.ResourcePool[][] resourceSets( Agent agent ) {
        return _service_resourceSets_xjal( this, agent );
      }
      @Override
      public double delayTime( Agent agent ) {
        return _service_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return HOUR;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_service_xjal( final com.anylogic.libraries.processmodeling.Service<Agent> self, TableInput _t ) {
    self.seizeFromOnePool = self._seizeFromOnePool_DefaultValue_xjal();
    self.queueCapacity = self._queueCapacity_DefaultValue_xjal();
    self.maximumCapacity = 
true 
;
    self.destinationType = self._destinationType_DefaultValue_xjal();
    self.entityLocationQueue = self._entityLocationQueue_DefaultValue_xjal();
    self.entityLocationDelay = self._entityLocationDelay_DefaultValue_xjal();
    self.suspendResumeEntities = self._suspendResumeEntities_DefaultValue_xjal();
    self.customizeResourceChoice = self._customizeResourceChoice_DefaultValue_xjal();
    self.enableTimeout = self._enableTimeout_DefaultValue_xjal();
    self.enablePreemption = self._enablePreemption_DefaultValue_xjal();
    self.restoreEntityLocationOnExit = self._restoreEntityLocationOnExit_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_service_xjal( com.anylogic.libraries.processmodeling.Service<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.MoveTo<Agent> instantiate_moveTo_xjal() {
    com.anylogic.libraries.processmodeling.MoveTo<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.MoveTo<Agent>( getEngine(), this, null ) {
      @Override
      public INode destinationNode( Agent agent ) {
        return _moveTo_destinationNode_xjal( this, agent );
      }
      @Override
      public com.anylogic.libraries.processmodeling.MoveTo.MovementType movementType( Agent agent ) {
        return _moveTo_movementType_xjal( this, agent );
      }
      @Override
      public double tripTime( Agent agent ) {
        return _moveTo_tripTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_tripTime() {
        return HOUR;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_moveTo_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.destinationType = self._destinationType_DefaultValue_xjal();
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
  private void doBeforeCreate_moveTo_xjal( com.anylogic.libraries.processmodeling.MoveTo<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Queue<Agent> instantiate_queue_xjal() {
    com.anylogic.libraries.processmodeling.Queue<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Queue<Agent>( getEngine(), this, null ) {
      @Override
      public boolean comparison( Agent agent1, Agent agent2 ) {
        return _queue_comparison_xjal( this, agent1, agent2 );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_queue_xjal( final com.anylogic.libraries.processmodeling.Queue<Agent> self, TableInput _t ) {
    self.capacity = self._capacity_DefaultValue_xjal();
    self.maximumCapacity = 
true 
;
    self.entityLocation = 
path 
;
    self.queuing = 
self.QUEUING_COMPARISON 
;
    self.enableTimeout = self._enableTimeout_DefaultValue_xjal();
    self.enablePreemption = self._enablePreemption_DefaultValue_xjal();
    self.restoreEntityLocationOnExit = self._restoreEntityLocationOnExit_DefaultValue_xjal();
    self.forceStatisticsCollection = self._forceStatisticsCollection_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_queue_xjal( com.anylogic.libraries.processmodeling.Queue<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Seize<Agent> instantiate_seize_xjal() {
    com.anylogic.libraries.processmodeling.Seize<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Seize<Agent>( getEngine(), this, null ) {
      @Override
      public com.anylogic.libraries.processmodeling.ResourcePool[][] resourceSets( Agent agent ) {
        return _seize_resourceSets_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_seize_xjal( final com.anylogic.libraries.processmodeling.Seize<Agent> self, TableInput _t ) {
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
  private void doBeforeCreate_seize_xjal( com.anylogic.libraries.processmodeling.Seize<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Agent> instantiate_delay_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Agent>( getEngine(), this, null ) {
      @Override
      public double delayTime( Agent agent ) {
        return _delay_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return HOUR;
      }
      @Override
      public void onExit( Agent agent ) {
        _delay_onExit_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_delay_xjal( final com.anylogic.libraries.processmodeling.Delay<Agent> self, TableInput _t ) {
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
  private void doBeforeCreate_delay_xjal( com.anylogic.libraries.processmodeling.Delay<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Release<Agent> instantiate_release_xjal() {
    com.anylogic.libraries.processmodeling.Release<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Release<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_release_xjal( final com.anylogic.libraries.processmodeling.Release<Agent> self, TableInput _t ) {
    self.releaseMode = 
self.ALL_FROM_SEIZES 
;
    self.seizeBlocks = new com.anylogic.libraries.processmodeling.Seize[]
{ seize } 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_release_xjal( com.anylogic.libraries.processmodeling.Release<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Source<Truck50T> instantiate_source50t_xjal() {
    com.anylogic.libraries.processmodeling.Source<Truck50T> _result_xjal = new com.anylogic.libraries.processmodeling.Source<Truck50T>( getEngine(), this, null ) {
      @Override
      public INode locationNode( Truck50T agent ) {
        return _source50t_locationNode_xjal( this, agent );
      }
      @Override
      public Agent newEntity(  ) {
        return _source50t_newEntity_xjal( this );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_source50t_xjal( final com.anylogic.libraries.processmodeling.Source<Truck50T> self, TableInput _t ) {
    self.arrivalType = 
self.MANUAL 
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
    self.locationType = 
self.LOCATION_NODE 
;
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
  private void doBeforeCreate_source50t_xjal( com.anylogic.libraries.processmodeling.Source<Truck50T> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Delay<Truck20T> instantiate_delay1_xjal() {
    com.anylogic.libraries.processmodeling.Delay<Truck20T> _result_xjal = new com.anylogic.libraries.processmodeling.Delay<Truck20T>( getEngine(), this, null ) {
      @Override
      public double delayTime( Truck20T agent ) {
        return _delay1_delayTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTime() {
        return SECOND;
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_delay1_xjal( final com.anylogic.libraries.processmodeling.Delay<Truck20T> self, TableInput _t ) {
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
  private void doBeforeCreate_delay1_xjal( com.anylogic.libraries.processmodeling.Delay<Truck20T> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.MoveTo<Agent> instantiate_moveTo1_xjal() {
    com.anylogic.libraries.processmodeling.MoveTo<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.MoveTo<Agent>( getEngine(), this, null ) {
      @Override
      public INode destinationNode( Agent agent ) {
        return _moveTo1_destinationNode_xjal( this, agent );
      }
      @Override
      public com.anylogic.libraries.processmodeling.MoveTo.MovementType movementType( Agent agent ) {
        return _moveTo1_movementType_xjal( this, agent );
      }
      @Override
      public double tripTime( Agent agent ) {
        return _moveTo1_tripTime_xjal( this, agent );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_tripTime() {
        return HOUR;
      }
      @Override
      public void onEnter( Agent agent ) {
        _moveTo1_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_moveTo1_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.destinationType = self._destinationType_DefaultValue_xjal();
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
  private void doBeforeCreate_moveTo1_xjal( com.anylogic.libraries.processmodeling.MoveTo<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.ResourcePool<Agent> instantiate_shovel_xjal() {
    com.anylogic.libraries.processmodeling.ResourcePool<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.ResourcePool<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_shovel_xjal( final com.anylogic.libraries.processmodeling.ResourcePool<Agent> self, TableInput _t ) {
    self.type = 
self.RESOURCE_STATIC 
;
    self.capacityDefinitionType = self._capacityDefinitionType_DefaultValue_xjal();
    self.capacity = self._capacity_DefaultValue_xjal();
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
  private void doBeforeCreate_shovel_xjal( com.anylogic.libraries.processmodeling.ResourcePool<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.ResourcePool<Agent> instantiate_crusher_xjal() {
    com.anylogic.libraries.processmodeling.ResourcePool<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.ResourcePool<Agent>( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_crusher_xjal( final com.anylogic.libraries.processmodeling.ResourcePool<Agent> self, TableInput _t ) {
    self.type = 
self.RESOURCE_STATIC 
;
    self.capacityDefinitionType = self._capacityDefinitionType_DefaultValue_xjal();
    self.capacity = self._capacity_DefaultValue_xjal();
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
  private void doBeforeCreate_crusher_xjal( com.anylogic.libraries.processmodeling.ResourcePool<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.Hold<Agent> instantiate_hold_xjal() {
    com.anylogic.libraries.processmodeling.Hold<Agent> _result_xjal = new com.anylogic.libraries.processmodeling.Hold<Agent>( getEngine(), this, null ) {
      @Override
      public void onEnter( Agent agent ) {
        _hold_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_hold_xjal( final com.anylogic.libraries.processmodeling.Hold<Agent> self, TableInput _t ) {
    self.mode = self._mode_DefaultValue_xjal();
    self.nEntitiesForSelfBlock = self._nEntitiesForSelfBlock_DefaultValue_xjal();
    self.initiallyBlocked = self._initiallyBlocked_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_hold_xjal( com.anylogic.libraries.processmodeling.Hold<Agent> self, TableInput _t ) {
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.PMLSettings instantiate_pMLSettings_xjal() {
    com.anylogic.libraries.processmodeling.PMLSettings _result_xjal = new com.anylogic.libraries.processmodeling.PMLSettings( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pMLSettings_xjal( final com.anylogic.libraries.processmodeling.PMLSettings self, TableInput _t ) {
    self.offsetForAttachedUnits = self._offsetForAttachedUnits_DefaultValue_xjal();
    self.animationLocationInitialCapacity = 
30 
;
    self.enableStatsByDefault = self._enableStatsByDefault_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_pMLSettings_xjal( com.anylogic.libraries.processmodeling.PMLSettings self, TableInput _t ) {
  }

  private INode _source20t_locationNode_xjal( final com.anylogic.libraries.processmodeling.Source<Truck20T> self, Truck20T agent ) {
    INode _value;
    _value = 
shovelArea 
;
    return _value;
  }
  private Agent _source20t_newEntity_xjal( final com.anylogic.libraries.processmodeling.Source<Truck20T> self ) {
    Agent _value;
    _value = 
new truck_quarry_operation.Truck20T() 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.ResourcePool[][] _service_resourceSets_xjal( final com.anylogic.libraries.processmodeling.Service<Agent> self, Agent agent ) {
    com.anylogic.libraries.processmodeling.ResourcePool[][] _value;
    _value = new com.anylogic.libraries.processmodeling.ResourcePool[][]
{ 
  { shovel }
} 
;
    return _value;
  }
  private double _service_delayTime_xjal( final com.anylogic.libraries.processmodeling.Service<Agent> self, Agent agent ) {
    double _value;
    _value = 
2 
;
    _value = HOUR.convertTo( _value, SECOND );
    return _value;
  }
  private INode _moveTo_destinationNode_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    INode _value;
    _value = 
crusherArea 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.MoveTo.MovementType _moveTo_movementType_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    com.anylogic.libraries.processmodeling.MoveTo.MovementType _value;
    _value = 
self.MOVE_TRIP_TIME 
;
    return _value;
  }
  private double _moveTo_tripTime_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    double _value;
    _value = 
1 
;
    _value = HOUR.convertTo( _value, SECOND );
    return _value;
  }
  private boolean _queue_comparison_xjal( final com.anylogic.libraries.processmodeling.Queue<Agent> self, Agent agent1, Agent agent2 ) {
    boolean _value;
    _value = 
agent1 instanceof Truck50T ? true : false 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.ResourcePool[][] _seize_resourceSets_xjal( final com.anylogic.libraries.processmodeling.Seize<Agent> self, Agent agent ) {
    com.anylogic.libraries.processmodeling.ResourcePool[][] _value;
    _value = new com.anylogic.libraries.processmodeling.ResourcePool[][]
{ 
  { crusher }
} 
;
    return _value;
  }
  private double _delay_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Agent> self, Agent agent ) {
    double _value;
    _value = 
5 
;
    _value = HOUR.convertTo( _value, SECOND );
    return _value;
  }
  private void _delay_onExit_xjal( final com.anylogic.libraries.processmodeling.Delay<Agent> self, Agent agent ) {
    
hold.unblock(); 
;
  }
  private INode _source50t_locationNode_xjal( final com.anylogic.libraries.processmodeling.Source<Truck50T> self, Truck50T agent ) {
    INode _value;
    _value = 
shovelArea 
;
    return _value;
  }
  private Agent _source50t_newEntity_xjal( final com.anylogic.libraries.processmodeling.Source<Truck50T> self ) {
    Agent _value;
    _value = 
new truck_quarry_operation.Truck50T() 
;
    return _value;
  }
  private double _delay1_delayTime_xjal( final com.anylogic.libraries.processmodeling.Delay<Truck20T> self, Truck20T agent ) {
    double _value;
    _value = 
1 
;
    return _value;
  }
  private INode _moveTo1_destinationNode_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    INode _value;
    _value = 
shovelArea 
;
    return _value;
  }
  private com.anylogic.libraries.processmodeling.MoveTo.MovementType _moveTo1_movementType_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    com.anylogic.libraries.processmodeling.MoveTo.MovementType _value;
    _value = 
self.MOVE_TRIP_TIME 
;
    return _value;
  }
  private double _moveTo1_tripTime_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    double _value;
    _value = 
1 
;
    _value = HOUR.convertTo( _value, SECOND );
    return _value;
  }
  private void _moveTo1_onEnter_xjal( final com.anylogic.libraries.processmodeling.MoveTo<Agent> self, Agent agent ) {
    
if (agent instanceof Truck20T) {

traceln("instance of Truck50T left the crusher");

} else {

traceln("instance of Truck50T left the crusher");

}


//Truck20T.this.roundRectangle6.setFillColor("peru"); 
;
  }
  private void _hold_onEnter_xjal( final com.anylogic.libraries.processmodeling.Hold<Agent> self, Agent agent ) {
    
self.block(); 
;
  }
  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  protected static final Color _roundRectangle1_Fill_Color = new Color( 0xFFE0AD9F, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle1 = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _roundRectangle = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _shovelArea = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _path = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _crusherArea = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _path1 = 6;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 7;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_network_xjal() {
	  network.addAll(shovelArea, path, crusherArea, path1);
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(roundRectangle1, roundRectangle, network);
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _path_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 100.0, 390.0, 0.0, 100.0, 350.0, 0.0 ),
       new MarkupSegmentLine( 100.0, 350.0, 0.0, 750.0, 350.0, 0.0 ),
       new MarkupSegmentLine( 750.0, 350.0, 0.0, 750.0, 390.0, 0.0 ), };
  }
  @AnyLogicInternalCodegenAPI
  private static MarkupSegment[] _path1_segments_xjal() {
    return new MarkupSegment[] {
       new MarkupSegmentLine( 740.0, 400.0, 0.0, 110.0, 400.0, 0.0 ), };
  }

  protected ShapeRoundedRectangle roundRectangle1;
  protected ShapeRoundedRectangle roundRectangle;
  protected PointNode shovelArea;
  protected Path path;
  protected PointNode crusherArea;
  protected Path path1;
  protected com.anylogic.engine.markup.Network network;

  private INetwork[] _getNetworks_xjal;

  @Override
  public INetwork[] getNetworks() {
    return _getNetworks_xjal;
  }

  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    roundRectangle1 = new ShapeRoundedRectangle(
		true,50.0, 300.0, 0.0, 
        black, _roundRectangle1_Fill_Color,
		750.0, 150.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    roundRectangle = new ShapeRoundedRectangle(
		true,-200.0, 20.0, 0.0, 
        black, white,
		160.0, 90.0,10.0,  
		1.0, LINE_STYLE_SOLID	 );

    path = new Path( this, SHAPE_DRAW_2D3D, true, false, false, 10, false, 5, PATH_DASHEDLINE, dodgerBlue, 1.0, _path_segments_xjal() );

    path1 = new Path( this, SHAPE_DRAW_2D3D, true, false, false, 10, false, 10, PATH_DASHEDLINE, dodgerBlue, 1.0, _path1_segments_xjal() );

    shovelArea = new PointNode(this, SHAPE_DRAW_2D3D, true, 100.0, 400.0, 0.0, 10.0, blue, false, 10.0, new PathEnd[] { new PathEnd(path1, PathEndType.END), new PathEnd(path, PathEndType.BEGIN)}, 
			new PathConnector(path1, path, false, 
   new MarkupSegmentArc( 110.0, 400.0, 0.0, 100.0, 390.0, 0.0, 4.71238898038469, 3.141592653589793, 1.0,
		110.0, 410.0, 10.0, -1.5707963267948966, -0.0,
		110.0, 390.0, 10.0, -4.71238898038469, 1.5707963267948966 )) );

    crusherArea = new PointNode(this, SHAPE_DRAW_2D3D, true, 750.0, 400.0, 0.0, 10.0, dodgerBlue, false, 10.0, new PathEnd[] { new PathEnd(path, PathEndType.END), new PathEnd(path1, PathEndType.BEGIN)}, 
			new PathConnector(path, path1, false, 
   new MarkupSegmentArc( 750.0, 390.0, 0.0, 740.0, 400.0, 0.0, 3.141592653589793, 1.5707963267948966, 1.0,
		760.0, 390.0, 10.0, -3.141592653589793, -0.0,
		740.0, 390.0, 10.0, -0.0, 1.5707963267948966 )) );

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }


  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    network = new com.anylogic.engine.markup.Network(this, "network", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getNetworks_xjal = new INetwork[] { 
      network };
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
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
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
    source20t = instantiate_source20t_xjal();
    service = instantiate_service_xjal();
    moveTo = instantiate_moveTo_xjal();
    queue = instantiate_queue_xjal();
    seize = instantiate_seize_xjal();
    delay = instantiate_delay_xjal();
    release = instantiate_release_xjal();
    source50t = instantiate_source50t_xjal();
    delay1 = instantiate_delay1_xjal();
    moveTo1 = instantiate_moveTo1_xjal();
    shovel = instantiate_shovel_xjal();
    crusher = instantiate_crusher_xjal();
    hold = instantiate_hold_xjal();
    pMLSettings = instantiate_pMLSettings_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main() {
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
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_network_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "truck_quarry_operation.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Environments setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
    // Creating non-replicated embedded objects
    setupParameters_source20t_xjal( source20t, null );
    doBeforeCreate_source20t_xjal( source20t, null );
    source20t.createAsEmbedded();
    setupParameters_service_xjal( service, null );
    doBeforeCreate_service_xjal( service, null );
    service.createAsEmbedded();
    setupParameters_moveTo_xjal( moveTo, null );
    doBeforeCreate_moveTo_xjal( moveTo, null );
    moveTo.createAsEmbedded();
    setupParameters_queue_xjal( queue, null );
    doBeforeCreate_queue_xjal( queue, null );
    queue.createAsEmbedded();
    setupParameters_seize_xjal( seize, null );
    doBeforeCreate_seize_xjal( seize, null );
    seize.createAsEmbedded();
    setupParameters_delay_xjal( delay, null );
    doBeforeCreate_delay_xjal( delay, null );
    delay.createAsEmbedded();
    setupParameters_release_xjal( release, null );
    doBeforeCreate_release_xjal( release, null );
    release.createAsEmbedded();
    setupParameters_source50t_xjal( source50t, null );
    doBeforeCreate_source50t_xjal( source50t, null );
    source50t.createAsEmbedded();
    setupParameters_delay1_xjal( delay1, null );
    doBeforeCreate_delay1_xjal( delay1, null );
    delay1.createAsEmbedded();
    setupParameters_moveTo1_xjal( moveTo1, null );
    doBeforeCreate_moveTo1_xjal( moveTo1, null );
    moveTo1.createAsEmbedded();
    setupParameters_shovel_xjal( shovel, null );
    doBeforeCreate_shovel_xjal( shovel, null );
    shovel.createAsEmbedded();
    setupParameters_crusher_xjal( crusher, null );
    doBeforeCreate_crusher_xjal( crusher, null );
    crusher.createAsEmbedded();
    setupParameters_hold_xjal( hold, null );
    doBeforeCreate_hold_xjal( hold, null );
    hold.createAsEmbedded();
    setupParameters_pMLSettings_xjal( pMLSettings, null );
    doBeforeCreate_pMLSettings_xjal( pMLSettings, null );
    pMLSettings.createAsEmbedded();
	 // Port connectors with non-replicated objects
    moveTo.in.connect( service.out ); // connector
    queue.in.connect( moveTo.out ); // connector1
    delay.in.connect( seize.out ); // connector3
    release.in.connect( delay.out ); // connector4
    delay1.in.connect( source20t.out ); // connector5
    delay1.out.connect( service.in ); // connector6
    source50t.out.connect( service.in ); // connector7
    moveTo1.in.connect( release.out ); // connector8
    moveTo1.out.connect( service.in ); // connector9
    seize.in.connect( hold.out ); // connector2
    hold.in.connect( queue.out ); // connector10
    // Creating replicated embedded objects
    truck20Ts.setEnvironment( this );
    for ( int i = 0; i < truck20Ts.size(); i++ ) {
      Truck20T _a = truck20Ts.get(i); 
      setupParameters_truck20Ts_xjal( _a, i, null );
      doBeforeCreate_truck20Ts_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    truck50Ts.setEnvironment( this );
    for ( int i = 0; i < truck50Ts.size(); i++ ) {
      Truck50T _a = truck50Ts.get(i); 
      setupParameters_truck50Ts_xjal( _a, i, null );
      doBeforeCreate_truck50Ts_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    for (Agent embeddedObject : truck20Ts) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : truck50Ts) {
      embeddedObject.startAsEmbedded();
    }
    source20t.startAsEmbedded();
    service.startAsEmbedded();
    moveTo.startAsEmbedded();
    queue.startAsEmbedded();
    seize.startAsEmbedded();
    delay.startAsEmbedded();
    release.startAsEmbedded();
    source50t.startAsEmbedded();
    delay1.startAsEmbedded();
    moveTo1.startAsEmbedded();
    shovel.startAsEmbedded();
    crusher.startAsEmbedded();
    hold.startAsEmbedded();
    pMLSettings.startAsEmbedded();
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
source20t.inject(4);
source50t.inject(2); 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
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
    list.add( truck20Ts );
    list.add( truck50Ts );
    list.add( source20t );
    list.add( service );
    list.add( moveTo );
    list.add( queue );
    list.add( seize );
    list.add( delay );
    list.add( release );
    list.add( source50t );
    list.add( delay1 );
    list.add( moveTo1 );
    list.add( shovel );
    list.add( crusher );
    list.add( hold );
    list.add( pMLSettings );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    for (Agent _item : truck20Ts) {
      _item.onDestroy();
    }
    for (Agent _item : truck50Ts) {
      _item.onDestroy();
    }
    source20t.onDestroy();
    service.onDestroy();
    moveTo.onDestroy();
    queue.onDestroy();
    seize.onDestroy();
    delay.onDestroy();
    release.onDestroy();
    source50t.onDestroy();
    delay1.onDestroy();
    moveTo1.onDestroy();
    shovel.onDestroy();
    crusher.onDestroy();
    hold.onDestroy();
    pMLSettings.onDestroy();
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : truck20Ts) {
      _item.doFinish();
    }
    for (Agent _item : truck50Ts) {
      _item.doFinish();
    }
    source20t.doFinish();
    service.doFinish();
    moveTo.doFinish();
    queue.doFinish();
    seize.doFinish();
    delay.doFinish();
    release.doFinish();
    source50t.doFinish();
    delay1.doFinish();
    moveTo1.doFinish();
    shovel.doFinish();
    crusher.doFinish();
    hold.doFinish();
    pMLSettings.doFinish();
  }



}
