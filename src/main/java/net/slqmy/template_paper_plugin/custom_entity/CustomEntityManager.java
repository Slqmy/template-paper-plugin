package net.slqmy.template_paper_plugin.custom_entity;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import net.slqmy.template_paper_plugin.TemplatePaperPlugin;
import net.slqmy.template_paper_plugin.custom_entity.CustomEntity;
import net.slqmy.template_paper_plugin.custom_entity.AbstractCustomEntity;

public class CustomEntityManager {
  
  private Map<CustomEntity, AbstractCustomEntity<?>> customEntityMap = new HashMap<>();

  public CustomEntityManager(TemplatePaperPlugin plugin) {
  }

  public void addCustomEntity(CustomEntity itemId, AbstractCustomEntity<?> customItem) {
    customEntityMap.put(itemId, customItem);
  }

  public AbstractCustomEntity<?> getAbstractCustomEntity(CustomEntity itemId) {
    return customEntityMap.get(itemId);
  }

  public <E extends Entity> E spawnEntity(CustomEntity entityId, Location location) {
    return (E) getAbstractCustomEntity(entityId).getCustomEntity(location);
  }
}
