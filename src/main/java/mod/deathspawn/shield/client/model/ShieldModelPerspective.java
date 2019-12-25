package mod.deathspawn.shield.client.model;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.vecmath.Matrix4f;
import java.util.ArrayList;
import java.util.List;

public class ShieldModelPerspective implements IBakedModel {

    private String shieldName;

    public ShieldModelPerspective(String elementName)
    {
        this.shieldName = elementName;
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType)
    {
        ModelManager manager = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager();

        IBakedModel model;
        if(cameraTransformType != TransformType.GUI )
            model = manager.getModel(new ModelResourceLocation("shield:shield_" + this.shieldName, "inventory")); //Get held model
        else model = manager.getModel(new ModelResourceLocation("shield:shield_" + this.shieldName + "_3d", "inventory")); //Get inventory model

        return Pair.of(model, TRSRTransformation.identity().getMatrix());
    }

    @Override
    public boolean isAmbientOcclusion()
    {
        return false;
    }

    @Override
    public boolean isGui3d()
    {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer()
    {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return null;
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return ItemCameraTransforms.DEFAULT; //The requirement for this is a bug
    }

    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand)
    {
        return new ArrayList<BakedQuad>();
    }

    @Override
    public ItemOverrideList getOverrides()
    {
        return new ItemOverrideList(new ArrayList<ItemOverride>());
    }
}
