/*
 * This file is part of CitizensNpcProvider for NucleusFramework, licensed under the MIT License (MIT).
 *
 * Copyright (c) JCThePants (www.jcwhatever.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.jcwhatever.nucleus.providers.citizensnpc;

import com.jcwhatever.nucleus.Nucleus;
import com.jcwhatever.nucleus.providers.npc.events.NpcClickEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcDamageByBlockEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcDamageByEntityEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcDamageEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcDeathEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcDespawnEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcLeftClickEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcRightClickEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcSpawnEvent;
import com.jcwhatever.nucleus.providers.npc.events.NpcTargetedEvent;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import net.citizensnpcs.api.event.EntityTargetNPCEvent;
import net.citizensnpcs.api.event.NPCClickEvent;
import net.citizensnpcs.api.event.NPCDespawnEvent;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCSpawnEvent;

/*
 * 
 */
public class CitizensNpcListener implements Listener {


    private void onSpawn(NPCSpawnEvent event) {
        Npc npc = CitizensProvider.getInstance().getNpc(event.getNPC());
        if (npc == null)
            return;

        NpcSpawnEvent e = new NpcSpawnEvent(npc);
        npc.onNpcSpawn(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onDespawn(NPCDespawnEvent event) {
        Npc npc = CitizensProvider.getInstance().getNpc(event.getNPC());
        if (npc == null)
            return;

        NpcDespawnEvent e = new NpcDespawnEvent(npc);
        npc.onNpcDespawn(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onClick(NPCClickEvent event) {
        Npc npc = CitizensProvider.getInstance().getNpc(event.getNPC());
        if (npc == null)
            return;

        NpcClickEvent e = new NpcClickEvent(npc, event.getClicker());
        npc.onNpcClick(e);
        Nucleus.getEventManager().call(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onLeftClick(NPCLeftClickEvent event) {
        Npc npc = CitizensProvider.getInstance().getNpc(event.getNPC());
        if (npc == null)
            return;

        NpcLeftClickEvent e = new NpcLeftClickEvent(npc, event.getClicker());
        npc.onNpcLeftClick(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onRightClick(NPCLeftClickEvent event) {
        Npc npc = CitizensProvider.getInstance().getNpc(event.getNPC());
        if (npc == null)
            return;

        NpcRightClickEvent e = new NpcRightClickEvent(npc, event.getClicker());
        npc.onNpcRightClick(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onEntityTarget(EntityTargetNPCEvent event) {
        Npc npc = CitizensProvider.getInstance().getNpc(event.getNPC());
        if (npc == null)
            return;

        NpcTargetedEvent e = new NpcTargetedEvent(npc, event.getEntity());
        npc.onNpcEntityTarget(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onDamage(EntityDamageEvent event) {
        Npc npc = (Npc)CitizensProvider.getInstance().getNpc(event.getEntity());
        if (npc == null)
            return;

        NpcDamageEvent e = new NpcDamageEvent(npc, event);
        npc.onNpcDamage(e);
        Nucleus.getEventManager().call(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onDamageByBlock(EntityDamageByBlockEvent event) {
        Npc npc = (Npc)CitizensProvider.getInstance().getNpc(event.getEntity());
        if (npc == null)
            return;

        NpcDamageByBlockEvent e = new NpcDamageByBlockEvent(npc, event);
        npc.onNpcDamageByBlock(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onDamageByEntity(EntityDamageByEntityEvent event) {
        Npc npc = (Npc)CitizensProvider.getInstance().getNpc(event.getEntity());
        if (npc == null)
            return;

        NpcDamageByEntityEvent e = new NpcDamageByEntityEvent(npc, event);
        npc.onNpcDamageByEntity(e);
        Nucleus.getEventManager().callBukkit(this, e);

        event.setCancelled(e.isCancelled());
    }

    private void onDeath(EntityDeathEvent event) {
        Npc npc = (Npc)CitizensProvider.getInstance().getNpc(event.getEntity());
        if (npc == null)
            return;

        NpcDeathEvent e = new NpcDeathEvent(npc, event);
        npc.onNpcDeath(e);
        Nucleus.getEventManager().callBukkit(this, e);
    }
}
