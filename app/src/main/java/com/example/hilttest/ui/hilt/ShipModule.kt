package com.example.hilttest.ui.hilt

import com.example.hilttest.ui.BattleShip
import com.example.hilttest.ui.ContainerShip
import com.example.hilttest.ui.Ship
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ShipModule {

    @BattleShipQualifier
    @Binds
    abstract fun BattleShipImpl(battleShip: BattleShip): Ship

    @ContainerShipQualifier
    @Binds
    abstract fun ContainerShipImpl(containerShip: ContainerShip): Ship
}