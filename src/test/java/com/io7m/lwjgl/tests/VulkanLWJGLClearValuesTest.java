/*
 * Copyright © 2018 Mark Raynsford <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.lwjgl.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkClearDepthStencilValue;
import org.lwjgl.vulkan.VkClearValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.IntBuffer;
import java.util.List;

public final class VulkanLWJGLClearValuesTest
{
  private static final Logger LOG = LoggerFactory.getLogger(VulkanLWJGLClearValuesTest.class);

  private MemoryStack stack = MemoryStack.create();

  @BeforeEach
  public void testSetup()
  {
    LOG.debug("testSetup");
    this.stack = this.stack.push();
  }

  private static final class VulkanClearColorValue
  {
    private final int r;
    private final int g;
    private final int b;
    private final int a;

    public VulkanClearColorValue(
      final int r,
      final int g,
      final int b,
      final int a)
    {
      this.r = r;
      this.g = g;
      this.b = b;
      this.a = a;
    }

    public int r()
    {
      return this.r;
    }

    public int g()
    {
      return this.g;
    }

    public int b()
    {
      return this.b;
    }

    public int a()
    {
      return this.a;
    }

    static VulkanClearColorValue ofIntegersSigned(
      final int r,
      final int g,
      final int b,
      final int a)
    {
      return new VulkanClearColorValue(r, g, b, a);
    }
  }

  private static final class VulkanClearValue
  {
    private final VulkanClearColorValue color;
    private final VulkanClearDepthStencilValue depthStencil;

    private VulkanClearValue(
      final VulkanClearColorValue color,
      final VulkanClearDepthStencilValue depthStencil)
    {
      this.color = color;
      this.depthStencil = depthStencil;
    }

    public VulkanClearColorValue color()
    {
      return this.color;
    }

    public VulkanClearDepthStencilValue depthStencil()
    {
      return this.depthStencil;
    }

    public static VulkanClearValue of(
      final VulkanClearColorValue color,
      final VulkanClearDepthStencilValue depthStencil)
    {
      return new VulkanClearValue(color, depthStencil);
    }
  }

  private static final class VulkanClearDepthStencilValue
  {
    private float depth;
    private int stencil;

    private VulkanClearDepthStencilValue(
      final float depth,
      final int stencil)
    {
      this.depth = depth;
      this.stencil = stencil;
    }

    public float depth()
    {
      return this.depth;
    }

    public int stencil()
    {
      return this.stencil;
    }

    public static VulkanClearDepthStencilValue of(
      final float depth,
      final int stencil)
    {
      return new VulkanClearDepthStencilValue(depth, stencil);
    }
  }

  @Test
  public void testClearColorValueCreateInfoSigned()
  {
    final List<VulkanClearValue> values =
      List.of(
        VulkanClearValue.of(
          VulkanClearColorValue.ofIntegersSigned(0, 0, 0, 0),
          VulkanClearDepthStencilValue.of((float) 0, 0)),
        VulkanClearValue.of(
          VulkanClearColorValue.ofIntegersSigned(1, 1, 1, 1),
          VulkanClearDepthStencilValue.of(1.0F, 1)),
        VulkanClearValue.of(
          VulkanClearColorValue.ofIntegersSigned(2, 2, 2, 2),
          VulkanClearDepthStencilValue.of(2.0F, 2)),
        VulkanClearValue.of(
          VulkanClearColorValue.ofIntegersSigned(3, 3, 3, 3),
          VulkanClearDepthStencilValue.of(3.0F, 3)));

    /*
     * Pack all of the above structures into an array of Vulkan Vk* structures.
     */

    final VkClearValue.Buffer packed_structures;

    {
      final int count = values.size();
      packed_structures = VkClearValue.mallocStack(values.size(), this.stack);

      for (int source_index = 0; source_index < count; ++source_index) {
        final VulkanClearValue clear = values.get(source_index);
        final VulkanClearColorValue color = clear.color();
        final VulkanClearDepthStencilValue depth_stencil = clear.depthStencil();

        packed_structures.position(source_index);

        final IntBuffer target_color = packed_structures.color().uint32();
        final VkClearDepthStencilValue target_depth = packed_structures.depthStencil();

        target_color.put(0, color.r());
        target_color.put(1, color.g());
        target_color.put(2, color.b());
        target_color.put(3, color.a());
        target_depth.set(depth_stencil.depth(), depth_stencil.stencil());
      }
    }

    /*
     * Read back the values from the array to check validity.
     */

    for (int index = 0; index < 4; ++index) {
      final VkClearValue value = packed_structures.get(index);

      final IntBuffer ci = value.color().uint32();
      final int r = ci.get(0);
      final int g = ci.get(1);
      final int b = ci.get(2);
      final int a = ci.get(3);
      LOG.debug("{} r 0x{}", Integer.valueOf(index), Integer.toUnsignedString(r, 16));
      LOG.debug("{} g 0x{}", Integer.valueOf(index), Integer.toUnsignedString(g, 16));
      LOG.debug("{} b 0x{}", Integer.valueOf(index), Integer.toUnsignedString(b, 16));
      LOG.debug("{} a 0x{}", Integer.valueOf(index), Integer.toUnsignedString(a, 16));

      final VkClearDepthStencilValue ds = value.depthStencil();
      LOG.debug("{} depth {}", Integer.valueOf(index), Float.valueOf(ds.depth()));
      LOG.debug("{} stencil {}", Integer.valueOf(index), Integer.valueOf(ds.stencil()));

      Assertions.assertEquals(index, r, "r-" + index);
      Assertions.assertEquals(index, g, "g-" + index);
      Assertions.assertEquals(index, b, "b-" + index);
      Assertions.assertEquals(index, a, "a-" + index);
      Assertions.assertEquals(index, ds.stencil());
      Assertions.assertEquals((float) index, ds.depth(), 0.0001f);
    }
  }
}
