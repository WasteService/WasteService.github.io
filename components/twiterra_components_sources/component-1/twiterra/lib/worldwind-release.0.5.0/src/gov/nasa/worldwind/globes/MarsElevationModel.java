/*
Copyright (C) 2001, 2006 United States Government
as represented by the Administrator of the
National Aeronautics and Space Administration.
All Rights Reserved.
*/
package gov.nasa.worldwind.globes;

import gov.nasa.worldwind.avlist.*;
import gov.nasa.worldwind.geom.*;
import gov.nasa.worldwind.util.LevelSet;
import gov.nasa.worldwind.Configuration;

/**
 * @author Patrick Murris
 * @version $Id: MarsElevationModel.java 5189 2008-04-27 04:06:56Z patrickmurris $
 */
public class MarsElevationModel extends BasicElevationModel
{
    private static double HEIGHT_OF_OLYMPUS_MONS = 22000d; // meters
    private static double DEPTH_OF_HELLAS_BASIN = -8000d; // meters

    public MarsElevationModel()
    {
        super(makeLevels(), DEPTH_OF_HELLAS_BASIN, HEIGHT_OF_OLYMPUS_MONS);
        this.setNumExpectedValuesPerTile(22500);
        String extremesFileName =
            Configuration.getStringValue("gov.nasa.worldwind.avkey.ExtremeElevations.MarsTopo.FileName");
        if (extremesFileName != null)
            this.loadExtremeElevations(extremesFileName);
    }

    private static LevelSet makeLevels()
    {
        AVList params = new AVListImpl();

        params.setValue(AVKey.TILE_WIDTH, 150);
        params.setValue(AVKey.TILE_HEIGHT, 150);
        params.setValue(AVKey.DATA_CACHE_NAME, "Mars/molazip");
        params.setValue(AVKey.SERVICE, "http://worldwind25.arc.nasa.gov/mars/mars.aspx");
        params.setValue(AVKey.DATASET_NAME, "molazip");
        params.setValue(AVKey.FORMAT_SUFFIX, ".bil");
        params.setValue(AVKey.NUM_LEVELS, 8);
        params.setValue(AVKey.NUM_EMPTY_LEVELS, 0);
        params.setValue(AVKey.LEVEL_ZERO_TILE_DELTA, new LatLon(Angle.fromDegrees(20d), Angle.fromDegrees(20d)));
        params.setValue(AVKey.SECTOR, Sector.FULL_SPHERE);
        return new LevelSet(params);
    }
}