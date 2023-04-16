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

import org.graalvm.compiler.lir.amd64.AMD64Move.LeaDataOp; 

/**
 * TODO:<br>
 * <br>
 * > Collect costs on totalDowntime, totalStockouts, fleetUtilization<br>
 * > Add revenue components<br>
 * > Add experiment with larger vessels<br>
 * > Prioritize oil rigs based on distance<br>
 * > Make variations for fleets (fuel cost, maintenance, repairs, leasing cost vs. acquisition, personnel)<br>
 * > States of weather affects speed/arbortion of mission<br>
 * > Upstream supply fails/reduces<br>
 * > Reduction of rate of depletion
 */
public class BaselineScenario extends Agent
{
  // Parameters

  public 
int  NumerOfVessels;

  /**
   * Returns default value for parameter <code>NumerOfVessels</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _NumerOfVessels_DefaultValue_xjal() {
    final BaselineScenario self = this;
    return 
4 
;
  }

  public void set_NumerOfVessels( int value ) {
    if (value == this.NumerOfVessels) {
      return;
    }
    int _oldValue_xjal = this.NumerOfVessels;
    this.NumerOfVessels = value;
    onChange_NumerOfVessels_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter NumerOfVessels.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_NumerOfVessels()</code> method instead.
   */
  protected void onChange_NumerOfVessels() {
    onChange_NumerOfVessels_xjal( NumerOfVessels );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_NumerOfVessels_xjal( int oldValue ) {  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    NumerOfVessels = _NumerOfVessels_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "NumerOfVessels":
      if ( _callOnChange_xjal ) {
        set_NumerOfVessels( ((Number) _value_xjal).intValue() );
      } else {
        NumerOfVessels = ((Number) _value_xjal).intValue();
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
    case "NumerOfVessels": _result_xjal = NumerOfVessels; break;
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
      list.add( "NumerOfVessels" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }

  // Collection Variables
  public 
ArrayList <
GISPoint > OilRigs = new ArrayList<GISPoint>();
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( BaselineScenario.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }


  // Events
	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot1_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot2_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot3_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot4_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _plot5_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _plot_autoUpdateEvent_xjal ) return "plot auto update event";
     if( _e == _plot1_autoUpdateEvent_xjal ) return "plot1 auto update event";
     if( _e == _plot2_autoUpdateEvent_xjal ) return "plot2 auto update event";
     if( _e == _plot3_autoUpdateEvent_xjal ) return "plot3 auto update event";
     if( _e == _plot4_autoUpdateEvent_xjal ) return "plot4 auto update event";
     if( _e == _plot5_autoUpdateEvent_xjal ) return "plot5 auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _plot_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot1_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot2_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot3_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot4_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _plot5_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot1_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot2_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot3_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot4_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if ( _e == _plot5_autoUpdateEvent_xjal ) {
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
    if( _e == _plot_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot1_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot2_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot3_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot4_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, HOUR );
      return _t;
    }
    if( _e == _plot5_autoUpdateEvent_xjal) {
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
    if ( _e == _plot_autoUpdateEvent_xjal ) {
      plot.updateData();
      return;
    }
    if ( _e == _plot1_autoUpdateEvent_xjal ) {
      plot1.updateData();
      return;
    }
    if ( _e == _plot2_autoUpdateEvent_xjal ) {
      plot2.updateData();
      return;
    }
    if ( _e == _plot3_autoUpdateEvent_xjal ) {
      plot3.updateData();
      return;
    }
    if ( _e == _plot4_autoUpdateEvent_xjal ) {
      plot4.updateData();
      return;
    }
    if ( _e == _plot5_autoUpdateEvent_xjal ) {
      plot5.updateData();
      return;
    }
    super.executeActionOf( _e );
  }

	

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _oilRigs_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _dock_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _vessels_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);
  public Dock dock;

  public String getNameOf( Agent ao ) {
    if ( ao == dock ) return "dock";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    if ( ao == dock ) return _dock_animationSettings_xjal;
    return super.getAnimationSettingsOf( ao );
  }

  public class _oilRigs_Population extends AgentArrayList<OilRig> {
    _oilRigs_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public OilRig instantiateAgent( int index ) {
    	return instantiate_oilRigs_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( OilRig agent, int index, TableInput tableInput ) {
      setupParameters_oilRigs_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( OilRig agent, int index, TableInput tableInput ) {
      doBeforeCreate_oilRigs_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "OilRig")
  public _oilRigs_Population oilRigs = new _oilRigs_Population( this );
  public class _vessels_Population extends AgentArrayList<Truck> {
    _vessels_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public Truck instantiateAgent( int index ) {
    	return instantiate_vessels_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Truck agent, int index, TableInput tableInput ) {
      setupParameters_vessels_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Truck agent, int index, TableInput tableInput ) {
      doBeforeCreate_vessels_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Truck")
  public _vessels_Population vessels = new _vessels_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == oilRigs ) return "oilRigs";
    if( aolist == vessels ) return "vessels";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    if( aolist == oilRigs ) return _oilRigs_animationSettings_xjal;
    if( aolist == vessels ) return _vessels_animationSettings_xjal;
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in oilRigs
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public OilRig oilRigs(int index) {
    return oilRigs.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection oilRigs<br>
   * @return newly created embedded object
   */
  public OilRig add_oilRigs() {
    int index = oilRigs.size();
    OilRig _result_xjal = instantiate_oilRigs_xjal( index );
    oilRigs.callSetupParameters( _result_xjal, index );
    oilRigs.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection oilRigs<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>oilRigs.size()</code> method <strong>before</strong> this method is called
   * @param ROP
   * @return newly created embedded object
   */
  public OilRig add_oilRigs( int ROP ) {
    int index = oilRigs.size();
    OilRig _result_xjal = instantiate_oilRigs_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.ROP = ROP;
    // Finish embedded object creation
    oilRigs.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection oilRigs<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object oilRigs - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to oilRigs
   */
  public boolean remove_oilRigs( OilRig object ) {
    if( ! oilRigs._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    return true;
  }
  /**
   * Returns the agent element at the specified position in vessels
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Truck vessels(int index) {
    return vessels.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection vessels<br>
   * @return newly created embedded object
   */
  public Truck add_vessels() {
    int index = vessels.size();
    Truck _result_xjal = instantiate_vessels_xjal( index );
    vessels.callSetupParameters( _result_xjal, index );
    vessels.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection vessels<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>vessels.size()</code> method <strong>before</strong> this method is called
   * @param client
   * @param loadingCap
   * @return newly created embedded object
   */
  public Truck add_vessels( OilRig client, double loadingCap ) {
    int index = vessels.size();
    Truck _result_xjal = instantiate_vessels_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.client = client;
    _result_xjal.loadingCap = loadingCap;
    // Finish embedded object creation
    vessels.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection vessels<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object vessels - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to vessels
   */
  public boolean remove_vessels( Truck object ) {
    if( ! vessels._remove( object ) ) {
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
  protected OilRig instantiate_oilRigs_xjal( final int index ) {
    OilRig _result_xjal = new OilRig( getEngine(), this, oilRigs );
    
    oilRigs._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_oilRigs_xjal( final OilRig self, final int index, TableInput _t ) {
    self.ROP = self._ROP_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_oilRigs_xjal( OilRig self, final int index, TableInput _t ) {
    self.setEnvironment( this );
	INode node_xjal = 
OilRigs.get(index); 
;
	self.setLocationRandomInside( node_xjal );

    // Port connections
  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected Dock instantiate_dock_xjal() {
    Dock _result_xjal = new Dock( getEngine(), this, null );
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_dock_xjal( final Dock self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_dock_xjal( Dock self, TableInput _t ) {
    self.setEnvironment( this );
	INode node_xjal = 
Tananger 
;
	self.setLocationRandomInside( node_xjal );
  }
  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Truck instantiate_vessels_xjal( final int index ) {
    Truck _result_xjal = new Truck( getEngine(), this, vessels );
    
    vessels._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_vessels_xjal( final Truck self, final int index, TableInput _t ) {
    self.client = self._client_DefaultValue_xjal();
    self.loadingCap = self._loadingCap_DefaultValue_xjal();
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_vessels_xjal( Truck self, final int index, TableInput _t ) {
    self.setEnvironment( this );
	INode node_xjal = 
Tananger 
;
	self.setLocationRandomInside( node_xjal );

    // Port connections
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
dock.vessels.utilization() 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot1_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot1_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot1_expression0_dataSet_xjal_YValue() {
    return 
oilRigs.get(0).Inventory 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot1_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot1_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot1_expression1_dataSet_xjal_YValue() {
    return 
oilRigs.get(1).ROP 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot2_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot2_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot2_expression0_dataSet_xjal_YValue() {
    return 
oilRigs.get(1).Inventory 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot2_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot2_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot2_expression1_dataSet_xjal_YValue() {
    return 
oilRigs.get(1).ROP 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot3_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot3_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot3_expression0_dataSet_xjal_YValue() {
    return 
oilRigs.get(2).Inventory 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot3_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot3_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot3_expression1_dataSet_xjal_YValue() {
    return 
oilRigs.get(1).ROP 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot4_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot4_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot4_expression0_dataSet_xjal_YValue() {
    return 
oilRigs.get(3).Inventory 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot4_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot4_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot4_expression1_dataSet_xjal_YValue() {
    return 
oilRigs.get(1).ROP 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot5_expression0_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot5_expression0_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot5_expression0_dataSet_xjal_YValue() {
    return 
oilRigs.get(4).Inventory 
;
  }

  @AnyLogicInternalCodegenAPI
  public DataSet _plot5_expression1_dataSet_xjal = new DataSet( 100, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( DataSet _d ) {
      if ( time() == _lastUpdateX ) { return; }
      _d.add( time(), __plot5_expression1_dataSet_xjal_YValue() );
      _lastUpdateX = time();
    }
  } );
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double __plot5_expression1_dataSet_xjal_YValue() {
    return 
oilRigs.get(1).ROP 
;
  }

  public double totalDowntime;
  public void update_totalDowntime() {
    totalDowntime = 
sum( oilRigs, o->o.totalDowntime) ;
  }
  public void update_totalDowntime(double _value) {
    totalDowntime = _value;
  }

  public double totalStockouts;
  public void update_totalStockouts() {
    totalStockouts = 
sum( oilRigs, o->o.noOfStockouts) ;
  }
  public void update_totalStockouts(double _value) {
    totalStockouts = _value;
  }

  public double fleetUtilization;
  public void update_fleetUtilization() {
    fleetUtilization = 
dock.vessels.utilization() ;
  }
  public void update_fleetUtilization(double _value) {
    fleetUtilization = _value;
  }

  // View areas
  public ViewArea MainOperation = new ViewArea( this, "[MainOperation]", 0, 0, 1450, 600 );
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1450.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "MainOperation", this.MainOperation );
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 2 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = new Font("SansSerif", 1, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text3_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart1 = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot1 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot2 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot3 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot4 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _plot5 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle1 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _map = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _oilRigs_presentation = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _dock_presentation = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _vessels_presentation = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _Tananger = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _ivarAasen = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _johanSverdrup = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _ula = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _tambar = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _valhall = 26;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 27;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    if (_a == dock) { return true; }
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(rectangle1, map, rectangle, plot, chart1, plot1, line, plot2, plot3, plot4, plot5, text, text1, text2, text3, text4, line1);
  }

  protected TimePlot plot;
  protected Histogram chart1;
  protected TimePlot plot1;
  protected TimePlot plot2;
  protected TimePlot plot3;
  protected TimePlot plot4;
  protected TimePlot plot5;
  protected ShapeRectangle rectangle1;
  protected ShapeGISMap map;
  protected ShapeRectangle rectangle;
  protected ShapeLine line;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Ballast - Vessel 1: " + vessels.get(0).ballast 
);
  }
  
  protected ShapeText text;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text1_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Ballast - Vessel 2: " + vessels.get(1).ballast 
);
  }
  
  protected ShapeText text1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text2_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Ballast - Vessel 3: " + vessels.get(2).ballast 
);
  }
  
  protected ShapeText text2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text3_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Ballast - All Vessels: " + 

(vessels.get(0).ballast + 
vessels.get(1).ballast + 
vessels.get(2).ballast) 
);
  }
  
  protected ShapeText text3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text4_SetDynamicParams_xjal( ShapeText shape ) {
    shape.setText(
"Downtime hours - All Rigs: " + 

round(sum( oilRigs, o->o.totalDowntime)) 
);
  }
  
  protected ShapeText text4;
  protected ShapeLine line1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _oilRigs_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( BaselineScenario.this, SHAPE_DRAW_2D3D, true, 35.29236840592363, 127.44186182238113, 0.0, 0.0,
		false, true, _a );

    return shape;
  }

  protected ShapeAgentPopulationGroup oilRigs_presentation;
  protected ShapeEmbeddedObjectPresentation dock_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _vessels_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( BaselineScenario.this, SHAPE_DRAW_2D3D, true, 35.29236840592363, 127.44186182238113, 0.0, 0.0,
		false, true, _a );

    return shape;
  }

  protected ShapeAgentPopulationGroup vessels_presentation;
  protected GISPoint Tananger;
  protected GISPoint ivarAasen;
  protected GISPoint johanSverdrup;
  protected GISPoint ula;
  protected GISPoint tambar;
  protected GISPoint valhall;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rectangle1 = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,1000.0, 0.0, 0.0, 0.0, 
            white, white,
			450.0, 600.0, 10.0, 1.0, LINE_STYLE_SOLID );

    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D3D, true,0.0, 460.0, 0.0, 0.0, 
            white, white,
			1000.0, 140.0, 10.0, 1.0, LINE_STYLE_SOLID );

    line = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 0.0, 460.0, 0.0, royalBlue, 
 		1000.0,	0.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );

    text = new ShapeText(
        SHAPE_DRAW_2D, true,280.0, 480.0, 0.0, 0.0, 
        black,"",
        _text_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,279.0, 500.0, 0.0, 0.0, 
        black,"",
        _text1_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,280.0, 520.0, 0.0, 0.0, 
        black,"",
        _text2_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,280.0, 550.0, 0.0, 0.0, 
        black,"",
        _text3_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,281.0, 573.0, 0.0, 0.0, 
        black,"",
        _text4_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    line1 = new ShapeLine(
		SHAPE_DRAW_2D3D, true, 1000.0, 0.0, 0.0, royalBlue, 
 		0.0,	460.0, 0.0, 3.0, 10.0, LINE_STYLE_SOLID );

    Tananger = new GISPoint( map, true, 58.9374656, 5.5896347, 3, defaultGisFillColor, brown, 1.0, LINE_STYLE_SOLID, "Tananger, Sola, Rogaland, 4056, Norge" );

    ivarAasen = new GISPoint( map, true, 59.0, 1.13, 3, defaultGisFillColor, brown, 1.0, LINE_STYLE_SOLID, "" );

    johanSverdrup = new GISPoint( map, true, 58.85, 1.55, 3, defaultGisFillColor, brown, 1.0, LINE_STYLE_SOLID, "" );

    ula = new GISPoint( map, true, 57.64, 2.5, 3, defaultGisFillColor, brown, 1.0, LINE_STYLE_SOLID, "" );

    tambar = new GISPoint( map, true, 57.42, 2.74, 3, defaultGisFillColor, brown, 1.0, LINE_STYLE_SOLID, "" );

    valhall = new GISPoint( map, true, 56.88, 3.197, 3, defaultGisFillColor, brown, 1.0, LINE_STYLE_SOLID, "" );

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 1 );
    _items.add( _plot_expression0_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Fleet Utilization" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 1 );
    _appearances.add( new Chart2DPlot.Appearance( black, true, false, Chart.INTERPOLATION_LINEAR, 2.0, Chart.POINT_NONE ) );
    plot = new TimePlot(
		    BaselineScenario.this, true, 1000.0, 460.0, 
			410.0, 140.0,
            null, null,
            50.0, 20.0,
			330.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _appearances );

    }
    {
    HistogramData _item;
    List<HistogramData> _items = new ArrayList<HistogramData>( 1 );
    _item = 
dock.LeadTimeEnd.distribution 
;
    _items.add( _item ); 
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Distribution of Lead Time" );
    List<Histogram.Appearance> _appearances = new ArrayList<Histogram.Appearance>( 1 );
    _appearances.add( new Histogram.Appearance( coral, goldenRod, royalBlue, lightSlateBlue, 1, darkMagenta ) );
    chart1 = new Histogram(
		    BaselineScenario.this, true, 10.0, 440.0, 
			210.0, 170.0,
            null, null,
            50.0, 40.0,
			130.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, 
            true, false, true, 0.91,
            _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 2 );
    _items.add( _plot1_expression0_dataSet_xjal ); 
    _items.add( _plot1_expression1_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 2 );
    _titles.add( "Inventory - Ivar Aasen" );
    _titles.add( "ROP  - Ivar Aasen" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 2 );
    _appearances.add( new Chart2DPlot.Appearance( new Color( 0xFF7A7A7A, true ), true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot1 = new TimePlot(
		    BaselineScenario.this, true, 1000.0, 0.0, 
			210.0, 140.0,
            null, null,
            50.0, 20.0,
			130.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 2 );
    _items.add( _plot2_expression0_dataSet_xjal ); 
    _items.add( _plot2_expression1_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 2 );
    _titles.add( "Inventory - Johan Sverdrup" );
    _titles.add( "ROP - Johan Sverdrup" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 2 );
    _appearances.add( new Chart2DPlot.Appearance( new Color( 0xFF7A7A7A, true ), true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot2 = new TimePlot(
		    BaselineScenario.this, true, 1200.0, 0.0, 
			210.0, 140.0,
            null, null,
            50.0, 20.0,
			130.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 2 );
    _items.add( _plot3_expression0_dataSet_xjal ); 
    _items.add( _plot3_expression1_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 2 );
    _titles.add( "Inventory - Ula" );
    _titles.add( "ROP  - Ula" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 2 );
    _appearances.add( new Chart2DPlot.Appearance( new Color( 0xFF7A7A7A, true ), true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot3 = new TimePlot(
		    BaselineScenario.this, true, 1000.0, 140.0, 
			210.0, 140.0,
            null, null,
            50.0, 20.0,
			130.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 2 );
    _items.add( _plot4_expression0_dataSet_xjal ); 
    _items.add( _plot4_expression1_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 2 );
    _titles.add( "Inventory - Tambar" );
    _titles.add( "ROP - Tambar" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 2 );
    _appearances.add( new Chart2DPlot.Appearance( new Color( 0xFF7A7A7A, true ), true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot4 = new TimePlot(
		    BaselineScenario.this, true, 1200.0, 140.0, 
			210.0, 140.0,
            null, null,
            50.0, 20.0,
			130.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _appearances );

    }
    {
    DataSet _item;
    List<DataSet> _items = new ArrayList<DataSet>( 2 );
    _items.add( _plot5_expression0_dataSet_xjal ); 
    _items.add( _plot5_expression1_dataSet_xjal ); 
    List<String> _titles = new ArrayList<String>( 2 );
    _titles.add( "Inventory - Valhall" );
    _titles.add( "ROP - Valhall" );
    List<Chart2DPlot.Appearance> _appearances = new ArrayList<Chart2DPlot.Appearance>( 2 );
    _appearances.add( new Chart2DPlot.Appearance( new Color( 0xFF7A7A7A, true ), true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    _appearances.add( new Chart2DPlot.Appearance( red, true, false, Chart.INTERPOLATION_LINEAR, 1.0, Chart.POINT_NONE ) );
    plot5 = new TimePlot(
		    BaselineScenario.this, true, 1000.0, 280.0, 
			210.0, 140.0,
            null, null,
            50.0, 20.0,
			130.0, 70.0, white, black, black,
            40.0, Chart.SOUTH,
            
100 
            , Chart.WINDOW_MOVES_WITH_TIME, null, Chart.SCALE_AUTO,
            0, 0, Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            null, darkGray, _items, _titles, _appearances );

    }
    oilRigs_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, oilRigs) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _oilRigs_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
    {
    dock_presentation = new ShapeEmbeddedObjectPresentation( BaselineScenario.this, SHAPE_DRAW_2D3D, true, 35.29236840592363, 127.44186182238113, 0.0, 0.0,
		false, true, null );

    }
    vessels_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, vessels) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _vessels_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
    dock_presentation.setEmbeddedObject_xjal( dock );
    dock_presentation.setEmbeddedObject_xjal( dock );
  }


  // Static initialization of persistent elements
  private void instantiatePersistentElements_xjal() {
    map = new ShapeGISMap(
		BaselineScenario.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0,
			1000.0, 600.0, "/agentmodelling/", new ShapeGISMap.Layer[] { }, 57.73021378088605, 5.799210140148131, 1.6666666666666668E-7, silver, 
		white, true, 
		TileURLProviderType.ANYLOGIC, 
		new AnyLogicOnlineRouteProvider(RoutingMethod.FASTEST, RouteProviderTransportType.CAR), 
		1833, false );

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
  public BaselineScenario( Engine engine, Agent owner, AgentList<? extends BaselineScenario> ownerPopulation ) {
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
    dock = instantiate_dock_xjal();
	instantiatePersistentElements_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public BaselineScenario() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public BaselineScenario( int NumerOfVessels ) {
    markParametersAreSet();
    this.NumerOfVessels = NumerOfVessels;
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
    {
      int _cnt = 
OilRigs.size(); 
;
      for ( int i = oilRigs.size(); i < _cnt; i++ ) {
        instantiate_oilRigs_xjal( i );
      }
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_BaselineScenario_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( BaselineScenario.this, true, 0, 0, 0, 0 , level, oilRigs_presentation, dock_presentation, vessels_presentation );
    addAll( OilRigs, new GISPoint[] 
{ ivarAasen, johanSverdrup, ula, tambar, valhall } 
    );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( BaselineScenario.this, getElementProperty( "agentmodelling.BaselineScenario.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Environments setup
    setupSpace( map );
    disableSteps();
    setNetworkUserDefined();
    // Creating non-replicated embedded objects
    setupParameters_dock_xjal( dock, null );
    doBeforeCreate_dock_xjal( dock, null );
    dock.createAsEmbedded();
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    oilRigs.setEnvironment( this );
    for ( int i = 0; i < oilRigs.size(); i++ ) {
      OilRig _a = oilRigs.get(i); 
      setupParameters_oilRigs_xjal( _a, i, null );
      doBeforeCreate_oilRigs_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    vessels.setEnvironment( this );
    for ( int i = 0; i < vessels.size(); i++ ) {
      Truck _a = vessels.get(i); 
      setupParameters_vessels_xjal( _a, i, null );
      doBeforeCreate_vessels_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( BaselineScenario.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _plot_autoUpdateEvent_xjal.start();
    _plot1_autoUpdateEvent_xjal.start();
    _plot2_autoUpdateEvent_xjal.start();
    _plot3_autoUpdateEvent_xjal.start();
    _plot4_autoUpdateEvent_xjal.start();
    _plot5_autoUpdateEvent_xjal.start();
    for (Agent embeddedObject : oilRigs) {
      embeddedObject.startAsEmbedded();
    }
    for (Agent embeddedObject : vessels) {
      embeddedObject.startAsEmbedded();
    }
    dock.startAsEmbedded();
  }
 

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_BaselineScenario_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_BaselineScenario_xjal() {
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
    list.add( oilRigs );
    list.add( dock );
    list.add( vessels );
    return list;
  }

  public AgentList<? extends BaselineScenario> getPopulation() {
    return (AgentList<? extends BaselineScenario>) super.getPopulation();
  }

  public List<? extends BaselineScenario> agentsInRange( double distance ) {
    return (List<? extends BaselineScenario>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _plot_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot1_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot2_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot3_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot4_autoUpdateEvent_xjal ) return false;
    if ( _e == _plot5_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _plot_autoUpdateEvent_xjal.onDestroy();
    _plot1_autoUpdateEvent_xjal.onDestroy();
    _plot2_autoUpdateEvent_xjal.onDestroy();
    _plot3_autoUpdateEvent_xjal.onDestroy();
    _plot4_autoUpdateEvent_xjal.onDestroy();
    _plot5_autoUpdateEvent_xjal.onDestroy();
    for (Agent _item : oilRigs) {
      _item.onDestroy();
    }
    dock.onDestroy();
    for (Agent _item : vessels) {
      _item.onDestroy();
    }
    map.destroy();
    _plot_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot1_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot1_expression1_dataSet_xjal.destroyUpdater_xjal();
    _plot2_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot2_expression1_dataSet_xjal.destroyUpdater_xjal();
    _plot3_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot3_expression1_dataSet_xjal.destroyUpdater_xjal();
    _plot4_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot4_expression1_dataSet_xjal.destroyUpdater_xjal();
    _plot5_expression0_dataSet_xjal.destroyUpdater_xjal();
    _plot5_expression1_dataSet_xjal.destroyUpdater_xjal();
    logToDB( _plot_expression0_dataSet_xjal, "plot : Fleet Utilization" );
    logToDB( _plot1_expression0_dataSet_xjal, "plot1 : Inventory - Ivar Aasen" );
    logToDB( _plot1_expression1_dataSet_xjal, "plot1 : ROP  - Ivar Aasen" );
    logToDB( _plot2_expression0_dataSet_xjal, "plot2 : Inventory - Johan Sverdrup" );
    logToDB( _plot2_expression1_dataSet_xjal, "plot2 : ROP - Johan Sverdrup" );
    logToDB( _plot3_expression0_dataSet_xjal, "plot3 : Inventory - Ula" );
    logToDB( _plot3_expression1_dataSet_xjal, "plot3 : ROP  - Ula" );
    logToDB( _plot4_expression0_dataSet_xjal, "plot4 : Inventory - Tambar" );
    logToDB( _plot4_expression1_dataSet_xjal, "plot4 : ROP - Tambar" );
    logToDB( _plot5_expression0_dataSet_xjal, "plot5 : Inventory - Valhall" );
    logToDB( _plot5_expression1_dataSet_xjal, "plot5 : ROP - Valhall" );
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : oilRigs) {
      _item.doFinish();
    }
    dock.doFinish();
    for (Agent _item : vessels) {
      _item.doFinish();
    }
    update_totalDowntime();
    update_totalStockouts();
    update_fleetUtilization();
  }



}
