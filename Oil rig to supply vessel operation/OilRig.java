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

public class OilRig extends Agent
{
  // Parameters

  public 
int  ROP;

  /**
   * Returns default value for parameter <code>ROP</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _ROP_DefaultValue_xjal() {
    final OilRig self = this;
    return 
100 
;
  }

  public void set_ROP( int value ) {
    if (value == this.ROP) {
      return;
    }
    int _oldValue_xjal = this.ROP;
    this.ROP = value;
    onChange_ROP_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter ROP.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_ROP()</code> method instead.
   */
  protected void onChange_ROP() {
    onChange_ROP_xjal( ROP );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_ROP_xjal( int oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    ROP = _ROP_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "ROP":
      if ( _callOnChange_xjal ) {
        set_ROP( ((Number) _value_xjal).intValue() );
      } else {
        ROP = ((Number) _value_xjal).intValue();
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
    case "ROP": _result_xjal = ROP; break;
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
      list.add( "ROP" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

  public 
double 
 totalDowntime;
  public 
double 
 entryTime;
  public 
double 
 exitTime;
  public 
int 
 noOfStockouts;
  public 
int 
 Inventory;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( OilRig.class );
  
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

  public EventTimeout InventoryDepletion = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == InventoryDepletion ) return "InventoryDepletion";
     if( _e == _plot_autoUpdateEvent_xjal ) return "plot auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == InventoryDepletion ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == InventoryDepletion ) {
      _t = 
1 
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
    if( _e == InventoryDepletion) {
      _t = 
normal(0, 1, 0.5, 0.5) 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == InventoryDepletion ) {
      EventTimeout self = _e;

// inventory cannot be depleted when it is empty
if(Inventory > 0)
	Inventory--;

// color the inventory-text red when ROP is reached
if(Inventory <= ROP){
	inventoryStatusTxt.setColor(red);
} else {
	inventoryStatusTxt.setColor(black);
} 
;
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
  protected static final int _STATECHART_COUNT_xjal = 1;


  // Statecharts
  public Statechart<StatechartSM_state> StatechartSM = new Statechart<>( this, (short)2 );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( Statechart _s ) {
    if(_s == this.StatechartSM) return "StatechartSM";
    return super.getNameOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getIdOf( Statechart _s ) {
    if(_s == this.StatechartSM) return 0;
    return super.getIdOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( Statechart _s ) {
    if( _s == this.StatechartSM ) {
      enterState( NormalOperations, true );
      return;
    }
    super.executeActionOf( _s );
  }

   // States of all statecharts
   
  public enum StatechartSM_state implements IStatechartState<OilRig, StatechartSM_state> {
    NormalOperations,
    WaitingReplenishment,
    InventoryEmpty;

    @AnyLogicInternalCodegenAPI
    private Collection<StatechartSM_state> _simpleStatesDeep_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<StatechartSM_state> _fullState_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<StatechartSM_state> _statesInside_xjal;

    @Override
    @AnyLogicInternalCodegenAPI
    public Collection<StatechartSM_state> getSimpleStatesDeep() {
      Collection<StatechartSM_state> result = _simpleStatesDeep_xjal;
      if (result == null) {
        _simpleStatesDeep_xjal = result = calculateAllSimpleStatesDeep();
      }
      return result;
    }
    
    @Override
    public Set<StatechartSM_state> getFullState() {
      Set<StatechartSM_state> result = _fullState_xjal;
      if (result == null) {
        _fullState_xjal = result = calculateFullState();
      }
      return result;
    }
    
    @Override
    @AnyLogicInternalCodegenAPI
    public Set<StatechartSM_state> getStatesInside() {
      Set<StatechartSM_state> result = _statesInside_xjal;
      if (result == null) {
        _statesInside_xjal = result = calculateStatesInside();
      }
      return result;
    }

    @Override
    @AnyLogicInternalCodegenAPI
    public Statechart<StatechartSM_state> getStatechart( OilRig _a ) {
      return _a.StatechartSM;
    }
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final StatechartSM_state NormalOperations = StatechartSM_state.NormalOperations;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final StatechartSM_state WaitingReplenishment = StatechartSM_state.WaitingReplenishment;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final StatechartSM_state InventoryEmpty = StatechartSM_state.InventoryEmpty;


  @AnyLogicInternalCodegenAPI
  private void enterState( StatechartSM_state self, boolean _destination ) {
    switch( self ) {
      case NormalOperations:
  	    logToDBEnterState(StatechartSM, self);
        // (Simple state (not composite))
        StatechartSM.setActiveState_xjal( NormalOperations );
        {
Inventory = 200; 
;}
        transition.start();
        return;
      case WaitingReplenishment:
  	    logToDBEnterState(StatechartSM, self);
        // (Simple state (not composite))
        StatechartSM.setActiveState_xjal( WaitingReplenishment );
        {
Order order = new Order(this);
send(order, baselineScenario.dock); 
;}
        transition1.start();
        transition2.start();
        return;
      case InventoryEmpty:
  	    logToDBEnterState(StatechartSM, self);
        // (Simple state (not composite))
        StatechartSM.setActiveState_xjal( InventoryEmpty );
        {
entryTime = time(); 
;}
        transition3.start();
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitState( StatechartSM_state self, Transition _t, boolean _source ) {
    switch( self ) {
      case NormalOperations: 
  	    logToDBExitState(StatechartSM, self);
  	    logToDB(StatechartSM, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != transition) transition.cancel();
        return;
      case WaitingReplenishment: 
  	    logToDBExitState(StatechartSM, self);
  	    logToDB(StatechartSM, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != transition1) transition1.cancel();
        if ( !_source || _t != transition2) transition2.cancel();
        return;
      case InventoryEmpty: 
  	    logToDBExitState(StatechartSM, self);
  	    logToDB(StatechartSM, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != transition3) transition3.cancel();
        {
exitTime = time();

totalDowntime += (exitTime - entryTime);

entryTime = 0;
exitTime = 0;

noOfStockouts++; 
;}
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitInnerStates( StatechartSM_state _destination ) {
    StatechartSM_state _state = StatechartSM.getActiveSimpleState();
    while( _state != _destination ) {
			exitState( _state, null, false );
			_state = _state.getContainerState();
		}
	}
  

  public TransitionCondition transition = new TransitionCondition( this );
  public TransitionCondition transition2 = new TransitionCondition( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionCondition _t ) {
    if ( _t == transition ) return "transition";
    if ( _t == transition2 ) return "transition2";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionCondition _t ) { 
    if ( _t == transition ) return StatechartSM;
    if ( _t == transition2 ) return StatechartSM;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionCondition self ) {
    if ( self == transition ) {
      exitState( NormalOperations, self, true );
          enterState( WaitingReplenishment, true );
      return;
    }
    if ( self == transition2 ) {
      exitState( WaitingReplenishment, self, true );
          enterState( InventoryEmpty, true );
      return;
    }
    super.executeActionOf( self );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testConditionOf( TransitionCondition _t ) {
    if ( _t == transition ) return 
Inventory <= ROP; 
;
    if ( _t == transition2 ) return 
Inventory == 0; 
;
    return super.testConditionOf( _t );
  }


  public TransitionMessage transition1 = new TransitionMessage( this );
  public TransitionMessage transition3 = new TransitionMessage( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionMessage _t ) {
    if ( _t == transition1 ) return "transition1";
    if ( _t == transition3 ) return "transition3";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionMessage _t ) { 
    if ( _t == transition1 ) return StatechartSM;
    if ( _t == transition3 ) return StatechartSM;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionMessage self, Object _msg ) {
    if ( self == transition1 ) {
      exitState( WaitingReplenishment, self, true );
          enterState( NormalOperations, true );
      return;
    }
    if ( self == transition3 ) {
      exitState( InventoryEmpty, self, true );
          enterState( NormalOperations, true );
      return;
    }
    super.executeActionOf( self, _msg );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testMessageOf( TransitionMessage _t, Object _msg ) {
    if ( _t == transition1 ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"delivered" 
;
      return msg.equals( _g );
    }
    if ( _t == transition3 ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"delivered" 
;
      return msg.equals( _g );
    }
    return super.testMessageOf( _t, _msg );
  }
  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
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
Inventory 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot_expression1_dataSet_xjal_YValue() {
    return 
ROP 
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
  protected static final Font _inventoryStatusTxt_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final int _plot = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _image = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _inventoryStatusTxt = 3;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 4;

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
	  level.addAll(plot, image, inventoryStatusTxt);
  }

  protected TimePlot plot;
  protected ShapeImage image;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _inventoryStatusTxt_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
Inventory 
);
  }
  
  protected ShapeText inventoryStatusTxt;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    image = new ShapeImage(
		OilRig.this, SHAPE_DRAW_2D3D, true, -12.8, -17.4, 0.0, 0.0, 
			25.0, 25.0, "/agentmodelling/", 
			new String[]{"oil-platform.png",}	 );

    inventoryStatusTxt = new ShapeText(
        SHAPE_DRAW_2D, true,-10.0, -40.0, 0.0, 0.0, 
        black,"text",
        _inventoryStatusTxt_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _inventoryStatusTxt_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 2 );
    _items.add( _plot_expression0_dataSet_xjal ); 
    _items.add( _plot_expression1_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 2 );
    _titles.add( "Inventory" );
    _titles.add( "Reorder Point" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 2 );
    _appearances.add( new Chart2DPlot.Appearance( black, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot = new TimePlot(
		    OilRig.this, false, 250.0, 370.0, 
			480.0, 230.0,
            null, null,
            50.0, 30.0,
			400.0, 140.0, white, black, black,
            30.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
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
  public OilRig( Engine engine, Agent owner, AgentList<? extends OilRig> ownerPopulation ) {
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
  public OilRig() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public OilRig( int ROP ) {
    markParametersAreSet();
    this.ROP = ROP;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_OilRig_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( OilRig.this, true, 0, 0, 0, 0 , level );
    icon = new ShapeModelElementsGroup( OilRig.this, getElementProperty( "agentmodelling.OilRig.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( OilRig.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    InventoryDepletion.start();
    _plot_autoUpdateEvent_xjal.start();
    StatechartSM.start();
  }
 

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_OilRig_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_OilRig_xjal() {
    Inventory = 
200 
;
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
    StatechartSM.fireEvent( _msg_xjal );
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends OilRig> getPopulation() {
    return (AgentList<? extends OilRig>) super.getPopulation();
  }

  public List<? extends OilRig> agentsInRange( double distance ) {
    return (List<? extends OilRig>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _plot_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    StatechartSM.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    InventoryDepletion.onDestroy();
    _plot_autoUpdateEvent_xjal.onDestroy();
    StatechartSM.onDestroy();
    _plot_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot_expression1_dataSet_xjal.destroyUpdater_xjal();
    logToDB( _plot_expression0_dataSet_xjal, "plot : Inventory" );
    logToDB( _plot_expression1_dataSet_xjal, "plot : Reorder Point" );
    super.onDestroy();
  }



}
